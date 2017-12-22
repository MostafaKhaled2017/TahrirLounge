package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.adapters.EventsAdapter;
import com.mostafa.tahrirlounge.adapters.TeamMembersAdapter;
import com.mostafa.tahrirlounge.pojoClasses.TeamMemberPojoClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 8/28/2017.
 */

public class OurTeam extends Fragment{
    List<TeamMemberPojoClass> teamMembersList = new ArrayList<>();
    View myView;
    RequestQueue requestQueue;
    CardView mCardView;
    RecyclerView ourTeamRecyclerView;
    private Context mContext;
    TeamMembersAdapter adapter;
    ProgressBar progress;
    private String url = "http://tahrirlounge.net/event/api/getAllTeamMembers";//TODO : make class for urls
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.fragment_our_team,container,false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ourTeamRecyclerView = (RecyclerView) myView.findViewById(R.id.our_team_recycler_view);
        ourTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progress = (ProgressBar) myView.findViewById(R.id.progressBar_of_our_team);
        mCardView = (CardView) myView.findViewById(R.id.our_team_card_view);
        // Get the application context
        mContext = getActivity().getApplicationContext();
        // Initialize a new RequestQueue instance
        if(teamMembersList.size()==0){
            Log.v("Loging","team members List size is : " + teamMembersList.size());
        requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (teamMembersList != null)
                            teamMembersList.clear();
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject teamMemberObject = response.getJSONObject(i);
                                String memberName = teamMemberObject.getString("memberName");
                                String memberPosition = teamMemberObject.getString("memberPosition");
                                String memberDescription = teamMemberObject.getString("memberDecription");
                                String memberImage = teamMemberObject.getString("imagePath");
                                Log.v("Logging","member name is :"+memberName);
                                Log.v("Logging","member position is :"+memberPosition);
                                Log.v("Logging","member image is :"+memberImage);
                                TeamMemberPojoClass teamMember=new TeamMemberPojoClass();
                                teamMember.setName(memberName);
                                teamMember.setPosition(memberPosition);
                                teamMember.setDescription(memberDescription);
                                teamMember.setImage(memberImage);
                                teamMembersList.add(teamMember);
                            }
                            Log.v("Logging","teamMembers list is :"+teamMembersList);
                            Log.v("Logging","list size is : "+teamMembersList.size());
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                        }
                    }
                    //TODO : Caching , dimensions
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (progress != null)
                            progress.setVisibility(View.GONE);
                        Toast.makeText(mContext, "Check your connection and try again", Toast.LENGTH_SHORT).show();
                        FragmentManager fm = getActivity().getFragmentManager();
                        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                            fm.popBackStack();
                        }
                        getFragmentManager().beginTransaction().replace(R.id.content_frame,new Home()).commit();
                    }
                });
                requestQueue.add(jsonArrayRequest).setTag("tag");}
        else{
        if (progress != null)
            progress.setVisibility(View.GONE);}
        adapter = new TeamMembersAdapter(getActivity(),teamMembersList);
        if(ourTeamRecyclerView.getAdapter()==null)
            ourTeamRecyclerView.setAdapter(adapter);
        return myView;
}}
