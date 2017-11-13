package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
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
import com.android.volley.toolbox.Volley;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.adapters.GalleryAdapter;
import com.mostafa.tahrirlounge.pojoClasses.GalleryPojoClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mostafa on 8/28/2017.
 */

public class Gallery extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    View myView;
    List<GalleryPojoClass> galleryList = new ArrayList<>();
    RecyclerView galleryRecyclerView;
    private Context mContext;
    private SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progress;
    List<String> galleryArrayList;
    private String mJSONURLString = "http://tahrirlounge.net/event/api/workshops";
    public Gallery(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_gallery, container, false);
        galleryRecyclerView = (RecyclerView) myView.findViewById(R.id.gallery_recycler_view);
        galleryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));//TODO : autofit the number of col.
        swipeRefreshLayout=(SwipeRefreshLayout) myView.findViewById(R.id.swipe_to_refresh_of_gallery);
        swipeRefreshLayout.setOnRefreshListener(this);
        progress = (ProgressBar) myView.findViewById(R.id.progressBar_of_gallery);
        mContext = getActivity().getApplicationContext();
        if(galleryList.size()==0){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.v("Logging","response is :" + response.toString());
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject galleryObject = response.getJSONObject(i);
                                String name = galleryObject.getString("name");
                                JSONArray galleryArray = galleryObject.getJSONArray("gallery");
                                galleryArrayList=new ArrayList<>();
                                for (int j=0;j<galleryArray.length();j++){
                                    String item=galleryArray.getString(j);
                                    galleryArrayList.add(item);
                                }
                                //POJO class to store
                                GalleryPojoClass album = new GalleryPojoClass();
                                album.setName(name);
                                album.setGallery(galleryArrayList);
                               Log.v("Logging","current album name : "+name);
                               Log.v("Logging","current album gallery : " +galleryArrayList);
                                galleryList.add(i,album);
                            }
                            Log.v("Logging","Gallery List is :" +galleryList.toString());
                            GalleryAdapter adapter = new GalleryAdapter(getActivity(),galleryList);
                            galleryRecyclerView.setAdapter(adapter);
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
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
                        getFragmentManager().beginTransaction().replace(R.id.content_frame,new Home()).commit();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);}
        else{//TODO: update data when it changed
            GalleryAdapter adapter = new GalleryAdapter(getActivity(),galleryList);
            galleryRecyclerView.setAdapter(adapter);
            if (progress != null)
                progress.setVisibility(View.GONE);
            adapter.notifyDataSetChanged();
        }

        return myView;
    }

    @Override
    public void onRefresh() {
        galleryList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.v("Logging","response is :" + response.toString());
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject galleryObject = response.getJSONObject(i);
                                String name = galleryObject.getString("name");
                                JSONArray galleryArray = galleryObject.getJSONArray("gallery");
                                galleryArrayList=new ArrayList<>();
                                for (int j=0;j<galleryArray.length();j++){
                                    String item=galleryArray.getString(j);
                                    galleryArrayList.add(item);
                                }
                                //POJO class to store
                                GalleryPojoClass album = new GalleryPojoClass();
                                album.setName(name);
                                album.setGallery(galleryArrayList);
                                Log.v("Logging","current album name : "+name);
                                Log.v("Logging","current album gallery : " +galleryArrayList);
                                galleryList.add(i,album);
                            }
                            Log.v("Logging","Gallery List is :" +galleryList.toString());
                            GalleryAdapter adapter = new GalleryAdapter(getActivity(),galleryList);
                            galleryRecyclerView.setAdapter(adapter);
                            if (progress != null)
                                progress.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
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
                        getFragmentManager().beginTransaction().replace(R.id.content_frame,new Home()).commit();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        Toast.makeText(mContext, "Data refreshed  successfully", Toast.LENGTH_SHORT).show();
        if(swipeRefreshLayout.isRefreshing())
        swipeRefreshLayout.setRefreshing(false);
    }}

