package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
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
    CardView mCardView;
    RecyclerView ourTeamRecyclerView;
    private Context mContext;
    ProgressBar progress;
    private String url = "http://209.126.105.42:8001/iosapi/getAllTeamMembers";//TODO : make class for urls
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
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        if(teamMembersList!=null){
            teamMembersList.clear();
        }
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray teamMembersArray =  response.getJSONArray("teamMembersList");
                            Log.v("Logging" , "response is:"+response.toString());
                            Log.v("Logging" , "team members array list is: "+teamMembersArray);
                            for (int i = 0; i< teamMembersArray.length(); i++){
                                TeamMemberPojoClass teamMember=new TeamMemberPojoClass();
                                JSONObject teamMemberObject = teamMembersArray.getJSONObject(i);
                                String memberName = teamMemberObject.getString("name");
                                String memberPosition = teamMemberObject.getString("position");
                                String memberDescription = teamMemberObject.getString("description");
                                String memberImage = teamMemberObject.getString("image");
                                Log.v("Logging","member name is :"+memberName);
                                Log.v("Logging","member position is :"+memberPosition);
                                Log.v("Logging","member image is :"+memberImage);

                                teamMember.setName(memberName);
                                teamMember.setPosition(memberPosition);
                                teamMember.setDescription(memberDescription);
                                teamMember.setImage(memberImage);
                                teamMembersList.add(teamMember);
                            }
                            Log.v("Logging","teamMembers list is :"+teamMembersList);
                            Log.v("Logging","list size is : "+teamMembersList.size());
                            TeamMembersAdapter adapter = new TeamMembersAdapter(getActivity(),teamMembersList);
                            ourTeamRecyclerView.setAdapter(adapter);
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (progress != null)
                            progress.setVisibility(View.GONE);
                        Toast.makeText(mContext, "Check your connection and try again", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.content_frame,new Home()).commit();
                    }
                });
        requestQueue.add(jsObjRequest);
        return myView;
}
}
