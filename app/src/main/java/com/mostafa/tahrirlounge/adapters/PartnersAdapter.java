package com.mostafa.tahrirlounge.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.pojoClasses.PartnersPojoClass;

import java.util.List;

public class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.PartnersViewHolder> {
private List<PartnersPojoClass> partnersList;
    private Context mContext;
    public PartnersAdapter(Context context, List<PartnersPojoClass> partnersList){
        this.mContext=context;
        this.partnersList=partnersList;

    }
    @Override
    public PartnersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.partner_item,parent,false);
        return new PartnersViewHolder(row);
    }
    @Override
    public void onBindViewHolder(PartnersViewHolder holder, int position) {
        final PartnersPojoClass partner = partnersList.get(position);
        Glide.with(holder.partnerImage.getContext()).load(partner.getImage()).placeholder(R.drawable.image_background).into(holder.partnerImage);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return partnersList.size();
    }
    class PartnersViewHolder extends RecyclerView.ViewHolder{
        TextView partnerName;
        AppCompatImageView partnerImage;
        PartnersViewHolder(View itemView) {
            super(itemView);
            partnerImage=(AppCompatImageView) itemView.findViewById(R.id.partner_item_image);
        }

    }
}

