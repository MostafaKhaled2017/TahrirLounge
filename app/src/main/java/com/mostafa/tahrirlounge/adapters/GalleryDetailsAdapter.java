package com.mostafa.tahrirlounge.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.fragments.GalleryImage;

import java.util.ArrayList;

public class GalleryDetailsAdapter extends RecyclerView.Adapter<GalleryDetailsAdapter.GalleryViewHolder> {
    ArrayList<String> galleryDetailsList =new ArrayList<>();
    private Context mContext;
    public GalleryDetailsAdapter(Context context, ArrayList<String> galleryDetailsList){
        this.mContext=context;
        this.galleryDetailsList = galleryDetailsList;

    }
    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_details_item,parent,false);
        return new GalleryViewHolder(row);
    }
    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        final String galleryImage = galleryDetailsList.get(position);
        Log.v("Logging","gallery image is " +galleryImage);
        Glide.with(mContext)
                .load(galleryImage)
                .placeholder(R.drawable.image_background)
                .into(holder.mainImage);
        holder.mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle imageBundle=new Bundle();
                GalleryImage galleryImageFragment=new GalleryImage();
                imageBundle.putString("image",galleryImage);
                galleryImageFragment.setArguments(imageBundle);
                ((Activity)mContext).getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,galleryImageFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return galleryDetailsList.size();
    }
    class GalleryViewHolder extends RecyclerView.ViewHolder{
        ImageView mainImage;
        public GalleryViewHolder(View itemView) {
            super(itemView);
           mainImage=(ImageView) itemView.findViewById(R.id.gallery_details_item_image);
        }

    }
}

