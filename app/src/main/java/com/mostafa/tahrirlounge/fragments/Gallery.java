package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
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

public class Gallery extends Fragment  {
    View myView;
    List<GalleryPojoClass> galleryList = new ArrayList<>();
    RecyclerView galleryRecyclerView;
    private Context mContext;
    RequestQueue requestQueue;
    ProgressBar progress;
    List<String> galleryArrayList;
    Home home;
    private String mJSONURLString = "http://tahrirlounge.net/event/api/workshops";
    public Gallery(){
    }

    public void passData(Home home1){home=home1;}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_gallery, container, false);
        galleryRecyclerView = (RecyclerView) myView.findViewById(R.id.gallery_recycler_view);
        galleryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));//TODO : autofit the number of col.
        progress = (ProgressBar) myView.findViewById(R.id.progressBar_of_gallery);
        mContext = getActivity().getApplicationContext();
        if(galleryList.size()==0){
        requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(galleryList!=null)
                            galleryList.clear();
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
                        String message = "check your connection and try again";
                        if (error instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                        } else if (error instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                        } else if (error instanceof TimeoutError) {
                            message = "Connection TimeOut! Please check your internet connection.";
                        }
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                        FragmentManager fm = getActivity().getFragmentManager();
                        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                            fm.popBackStack();
                        }
                        getFragmentManager().beginTransaction().replace(R.id.content_frame,home,"home").commit();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest).setTag("tag");
        }
        else{
            GalleryAdapter adapter = new GalleryAdapter(getActivity(),galleryList);
            galleryRecyclerView.setAdapter(adapter);
            if (progress != null)
                progress.setVisibility(View.GONE);
        }

        return myView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(galleryRecyclerView.getAdapter()==null) requestQueue.cancelAll("tag");
    }
}

