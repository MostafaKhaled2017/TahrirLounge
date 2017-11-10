package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
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
import com.android.volley.toolbox.Volley;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.adapters.PartnersAdapter;
import com.mostafa.tahrirlounge.pojoClasses.PartnersPojoClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 8/28/2017.
 */

public class OurPartners extends Fragment{
    List<PartnersPojoClass> partnersList = new ArrayList<>();
    View myView;
    RecyclerView partnersRecyclerView;
    private Context mContext;
    ProgressBar progress;
    private String mJSONURLString = "http://tahrirlounge.net/event/api/partners";
    public OurPartners() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.fragment_our_parteners,container,false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext = getActivity().getApplicationContext();
        // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        partnersRecyclerView= (RecyclerView) myView.findViewById(R.id.partners_recycler_view);
        // Initialize a new JsonArrayRequest instance
        if(partnersList.size()==0) {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    mJSONURLString,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                // Loop through the array elements
                                for (int i = 0; i < response.length(); i++) {
                                    // Get current json object
                                    JSONObject partnerObject = response.getJSONObject(i);

                                    String partnerName = partnerObject.getString("name");
                                    String partnerImage = partnerObject.getString("image");
                                    
                                    //POJO class to store
                                    PartnersPojoClass partner = new PartnersPojoClass();
                                    partner.setName(partnerName);
                                    partner.setImage(partnerImage);

                                    partnersList.add(partner);
                                }
                                PartnersAdapter adapter = new PartnersAdapter(getActivity(), partnersList);
                                partnersRecyclerView.setAdapter(adapter);
                                if (progress != null)
                                    progress.setVisibility(View.GONE);

                            } catch (JSONException e) {
                                e.printStackTrace();
                                if (progress != null)
                                    progress.setVisibility(View.GONE);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                            Toast.makeText(mContext, "Check your connection and try again", Toast.LENGTH_SHORT).show();
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new Home()).commit();
                        }
                    }
            );
            requestQueue.add(jsonArrayRequest);
        }
        else{
            PartnersAdapter adapter = new PartnersAdapter(getActivity(), partnersList);
            partnersRecyclerView.setAdapter(adapter);
            if (progress != null)
                progress.setVisibility(View.GONE);
    }
        return myView;
}
}
