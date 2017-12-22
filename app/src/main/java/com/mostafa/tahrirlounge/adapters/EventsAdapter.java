package com.mostafa.tahrirlounge.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.fragments.EventDetails;
import com.mostafa.tahrirlounge.pojoClasses.EventPojoClass;
import com.mostafa.tahrirlounge.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {
private List<EventPojoClass> eventsList;
    private Context mContext;
    public  EventsAdapter (Context context,List<EventPojoClass> eventsList){
        this.mContext=context;
        this.eventsList=eventsList;

    }
    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.events_card,parent,false);
        return new EventsViewHolder(row);
    }
    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        final EventPojoClass event = eventsList.get(position);
        holder.eventName.setText(event.getEventName());
        holder.eventDate.append(event.getEventDate());
        holder.eventDetails.setText(event.getEventDetails());
        holder.instructorName.append(event.getEventInstractor());
        Picasso.with(mContext)
                .load(event.getEventImage())
                .placeholder(R.drawable.image_background)
                .into(holder.eventImage);
        holder.seeMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle eventData=new Bundle();
                EventDetails eventDetailsFragment =new EventDetails();
                eventData.putString("eventName",event.getEventName());
                eventData.putString("eventDate",event.getEventDate());
                eventData.putString("eventDetails",event.getEventDetails());
                eventData.putString("instructorName",event.getEventInstractor());
                eventData.putString("eventImage",event.getEventImage());
                eventDetailsFragment.setArguments(eventData);
                ((Activity) mContext).getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, eventDetailsFragment)
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
        return eventsList.size();
    }
    class EventsViewHolder extends RecyclerView.ViewHolder{
        CardView eventsCard;
        TextView eventName,eventDate,instructorName,eventDetails;
        ImageView eventImage;
        Button seeMoreButton;
        EventsViewHolder(View itemView) {
            super(itemView);
            eventsCard=(CardView) itemView.findViewById(R.id.card_view_of_events) ;
            eventName= (TextView) itemView.findViewById(R.id.event_name);
            eventDate=(TextView) itemView.findViewById(R.id.event_date);
            instructorName=(TextView) itemView.findViewById(R.id.instructor_name);
            eventDetails=(TextView) itemView.findViewById(R.id.event_details);
            eventImage=(ImageView) itemView.findViewById(R.id.event_image);
            seeMoreButton=(Button) itemView.findViewById(R.id.see_more_button);
        }

    }
}

