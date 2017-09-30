package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.activities.MapsActivity;

/**
 * Created by Mostafa on 8/28/2017.
 */

public class ContactUs extends Fragment {
    View myView;
    Button button;
    TextView webSiteText;
    TextView phoneText;
    TextView locationText;
    Intent i;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        button = (Button) myView.findViewById(R.id.contact_us_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getActivity(),MapsActivity.class);
          startActivity(i);
}
        });
        webSiteText= (TextView) myView.findViewById(R.id.website_text);
        webSiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://tahrirlounge.net/"));
                startActivity(i);
            }
        });
        phoneText= (TextView) myView.findViewById(R.id.phone_text);
        phoneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                        "tel", "01274333113", null));
                startActivity(i);
            }
        });
        locationText=(TextView) myView.findViewById(R.id.location_text);
        locationText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getActivity(),MapsActivity.class);
                startActivity(i);
            }
        });

        return myView;
    }
}
