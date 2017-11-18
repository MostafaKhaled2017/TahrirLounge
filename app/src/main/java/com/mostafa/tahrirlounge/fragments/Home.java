package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafa.tahrirlounge.R;

/**
 * Created by Mostafa on 8/28/2017.
 */

public class Home extends Fragment{ 
    View myView;
    TextView facebookIconText,twitterIconText,youtubeIconText,aboutUsIconText,contactUsIconText,eventsIconText,ourTeamIconText;
    TextView ourPartnersIconText,galleryIconText;
    FacebookPage facebookPage=new FacebookPage();
    Twitter twitter =new Twitter();
    YouTube youTube=new YouTube();
    AboutUs aboutUs=new AboutUs();
    ContactUs contactUs=new ContactUs();
    Events events=new Events();
    OurTeam ourTeam=new OurTeam();
    OurPartners ourPartners=new OurPartners();
    Gallery gallery=new Gallery();
    NavigationView navigationView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_home, container, false);
        navigationView = (NavigationView) myView.findViewById(R.id.nav_view);
        facebookIconText = (TextView) myView.findViewById(R.id.facebook_icon_and_text_in_home);
        facebookIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,facebookPage)
                        .addToBackStack(null)
                        .commit();
            }
        });

        twitterIconText = (TextView) myView.findViewById(R.id.twitter_icon_and_text_in_home);
        twitterIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,twitter)
                        .addToBackStack(null)
                        .commit();
            }
        });
        youtubeIconText = (TextView) myView.findViewById(R.id.youtube_icon_and_text_in_home);
        youtubeIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,youTube)
                        .addToBackStack(null)
                        .commit();
            }
        });
        aboutUsIconText=(TextView) myView.findViewById(R.id.about_us_icon_and_text_in_home);
        aboutUsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,aboutUs)
                        .addToBackStack(null)
                        .commit();
            }
        });
        contactUsIconText = (TextView) myView.findViewById(R.id.contact_us_icon_and_text_in_home);
        contactUsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,contactUs)
                        .addToBackStack(null)
                        .commit();
            }
        });
        ourTeamIconText = (TextView) myView.findViewById(R.id.our_team_icon_and_text_in_home);
        ourTeamIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,ourTeam)
                        .addToBackStack(null)
                        .commit();
            }
        });
        ourPartnersIconText = (TextView) myView.findViewById(R.id.our_partners_icon_and_text_in_home);
        ourPartnersIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,ourPartners)
                        .addToBackStack(null)
                        .commit();
            }
        });
        eventsIconText = (TextView) myView.findViewById(R.id.events_icon_and_text_in_home);
        eventsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,events)
                        .addToBackStack(null)
                        .commit();
            }
        });
        galleryIconText = (TextView) myView.findViewById(R.id.gallery_icon_and_text_in_home);
        galleryIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,gallery)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return myView;
    }
}
