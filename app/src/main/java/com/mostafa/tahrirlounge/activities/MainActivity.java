package com.mostafa.tahrirlounge.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mostafa.tahrirlounge.fragments.AboutApp;
import com.mostafa.tahrirlounge.fragments.AboutUs;
import com.mostafa.tahrirlounge.fragments.ContactUs;
import com.mostafa.tahrirlounge.fragments.Events;
import com.mostafa.tahrirlounge.fragments.FacebookPage;
import com.mostafa.tahrirlounge.fragments.Gallery;
import com.mostafa.tahrirlounge.fragments.Home;
import com.mostafa.tahrirlounge.fragments.OurPartners;
import com.mostafa.tahrirlounge.fragments.OurTeam;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.fragments.Twitter;
import com.mostafa.tahrirlounge.fragments.YouTube;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    FacebookPage facebookPage=new FacebookPage();
    Twitter twitter =new Twitter();
    YouTube youTube=new YouTube();
    AboutUs aboutUs=new AboutUs();
    ContactUs contactUs=new ContactUs();
    Events events=new Events();
    OurTeam ourTeam=new OurTeam();
    OurPartners ourPartners=new OurPartners();
    Gallery gallery=new Gallery();
    Home home=new Home();
    AboutApp aboutApp=new AboutApp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
            getFragmentManager().beginTransaction().replace(R.id.content_frame, home).commit();
    }

    @Override
    public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager= getFragmentManager();
        if (id == R.id.nav_facebook_page) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,facebookPage)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_twitter) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,twitter)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_youtube) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,youTube)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_about_us){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,aboutUs)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_home){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new Home())
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_our_partners){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,ourPartners)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_our_team){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,ourTeam)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_events){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,events)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_contact_us){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,contactUs)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_gallery){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,gallery)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_home){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,home)
                    .addToBackStack(null)
                    .commit();
        }else if(id==R.id.nav_about_app){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,aboutApp)
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
