package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.adapters.EventsAdapter;
import com.mostafa.tahrirlounge.adapters.GalleryDetailsAdapter;

import java.util.ArrayList;


/**
 * Created by Mostafa on 8/28/2017.
 */

public class GalleryDetails extends Fragment {
    View myView;
   // ImageView mainImage;
    RecyclerView galleryDetailsRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_gallery_in_details, container, false);
      //  mainImage= (ImageView) myView.findViewById(R.id.main_image_in_gallery_details);
        galleryDetailsRecyclerView = (RecyclerView) myView.findViewById(R.id.gallery_details_recycler_view);
        galleryDetailsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));//TODO :autofit the number of col.
        Bundle galleryData = this.getArguments();
        Log.v("galleryDataLogging","gallery data bundle is : "+galleryData.toString());
        ArrayList<String> galleryImages=galleryData.getStringArrayList("album");
        Log.v("galleryDataLogging","gallery images is : "+galleryImages.toString());
       // Glide.with(getActivity()).load(galleryImages.get(0)).placeholder(R.drawable.image_background).into(mainImage);
        GalleryDetailsAdapter adapter = new GalleryDetailsAdapter(getActivity(),galleryImages);
        galleryDetailsRecyclerView.setAdapter(adapter);
        return myView;
    }

}
