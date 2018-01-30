package com.mostafa.tahrirlounge.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.pojoClasses.GalleryPojoClass;
import com.mostafa.tahrirlounge.fragments.GalleryDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private List<GalleryPojoClass> galleryList=new ArrayList<>();
    private Context mContext;
    public GalleryAdapter(Context context, List<GalleryPojoClass> galleryList){
        this.mContext=context;
        this.galleryList=galleryList;

    }
    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new GalleryViewHolder(row);
    }
    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        final GalleryPojoClass album = galleryList.get(position);
        holder.name.setText(album.getName());
        String mainImage=album.getGallery().get(0);
        Picasso.with(mContext)
                .load(mainImage)
                .placeholder(R.drawable.image_background)
                .into(holder.image);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle galleryData=new Bundle();
                GalleryDetails galleryDetailsFragment=new GalleryDetails();
                galleryData.putStringArrayList("album", (ArrayList<String>) album.getGallery());
                galleryDetailsFragment.setArguments(galleryData);
                ((Activity)mContext).getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,galleryDetailsFragment)
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
        return galleryList.size();
    }
    class GalleryViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        CardView card;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            card=(CardView) itemView.findViewById(R.id.card_view_of_gallery);
            name= (TextView) itemView.findViewById(R.id.gallery_item_info);
           image=(ImageView) itemView.findViewById(R.id.gallery_item_image);
        }

    }
}

