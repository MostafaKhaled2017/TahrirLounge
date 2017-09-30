package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.R;


/**
 * Created by Mostafa on 8/28/2017.
 */

public class EventDetails extends Fragment {
    View myView;
    TextView event_name, event_date,event_details,instructor_name;
    ImageView event_image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_event_in_details, container, false);
        Bundle eventData =this.getArguments();
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/JF Flat regular.otf");
        if (eventData !=null) {
            String eventName=eventData.getString("eventName");
            event_name= (TextView) myView.findViewById(R.id.event_name_in_details);
            event_date =(TextView) myView.findViewById(R.id.event_date_in_details);
            event_details=(TextView)myView.findViewById(R.id.event_details_in_details);
            instructor_name=(TextView)myView.findViewById(R.id.instractor_name_in_details);
            event_image=(ImageView)myView.findViewById(R.id.event_image_in_details);
            String eventDate=eventData.getString("eventDate");
            String eventDetails=eventData.getString("eventDetails");
            String instructorName=eventData.getString("instructorName");
            String eventImage=eventData.getString("eventImage");
            event_name.setText(eventName);
            event_name.setTypeface(custom_font);
            event_date.append(eventDate);
            event_date.setTypeface(custom_font);
            event_details.setText(eventDetails);
            event_details.setTypeface(custom_font);
            instructor_name.append(instructorName);
            instructor_name.setTypeface(custom_font);
            Glide.with(getActivity()).load(eventImage).placeholder(R.drawable.image_background).into(event_image);
        }else{
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new Home()).commit();
            Toast.makeText(getActivity(), "Error occured", Toast.LENGTH_SHORT).show();
        }
        return myView;
    }
}
