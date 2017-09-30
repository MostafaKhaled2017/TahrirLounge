package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;


/**
 * Created by Mostafa on 8/28/2017.
 */

public class GalleryImage extends Fragment {
    View myView;
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_gallery_image, container, false);
        imageView =(ImageView) myView.findViewById(R.id.gallery_image_in_full_screen);
        String imageURL=this.getArguments().getString("image");
        Glide.with(getActivity()).load(imageURL).placeholder(R.drawable.image_background).into(imageView);
        return myView;
    }
}
