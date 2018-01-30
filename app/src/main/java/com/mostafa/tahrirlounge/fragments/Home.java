package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafa.tahrirlounge.LogInDialogue;
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
    public void passData(Events events2,AboutUs aboutUs2,ContactUs contactUs2,OurTeam ourTeam2,OurPartners ourPartners2,Gallery gallery2){
        events=events2;
        aboutUs=aboutUs2;
        contactUs=contactUs2;
        ourTeam=ourTeam2;
        ourPartners=ourPartners2;
        gallery=gallery2;
                //TODO :thik in edit the initialization of variabales
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_home, container, false);
        navigationView = (NavigationView) myView.findViewById(R.id.nav_view);
        facebookIconText = (TextView) myView.findViewById(R.id.facebook_icon_and_text_in_home);
        facebookIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,facebookPage)
                        .addToBackStack(null)
                        .commit();*/
                Uri uri = Uri.parse("https://www.facebook.com/TahrirLounge/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        twitterIconText = (TextView) myView.findViewById(R.id.twitter_icon_and_text_in_home);
        twitterIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,twitter)
                        .addToBackStack(null)
                        .commit();*/
                Uri uri = Uri.parse("https://twitter.com/tahrirlounge");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        youtubeIconText = (TextView) myView.findViewById(R.id.youtube_icon_and_text_in_home);
        youtubeIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,youTube)
                        .addToBackStack(null)
                        .commit();*/
                Uri uri = Uri.parse("https://www.youtube.com/user/Tahrirlounge");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        aboutUsIconText=(TextView) myView.findViewById(R.id.about_us_icon_and_text_in_home);
        aboutUsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,aboutUs)
                        .commit();
            }
        });
        contactUsIconText = (TextView) myView.findViewById(R.id.contact_us_icon_and_text_in_home);
        contactUsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,contactUs)
                        .commit();
            }
        });
        ourTeamIconText = (TextView) myView.findViewById(R.id.our_team_icon_and_text_in_home);
        ourTeamIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,ourTeam)
                        .commit();
            }
        });
        ourPartnersIconText = (TextView) myView.findViewById(R.id.our_partners_icon_and_text_in_home);
        ourPartnersIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,ourPartners)
                        .commit();
            }
        });
        eventsIconText = (TextView) myView.findViewById(R.id.events_icon_and_text_in_home);
        eventsIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,events)
                        .commit();
            }
        });
        galleryIconText = (TextView) myView.findViewById(R.id.gallery_icon_and_text_in_home);
        galleryIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,gallery)
                        .commit();
            }
        });
        return myView;
    }

}
