package com.mostafa.tahrirlounge;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mostafa.tahrirlounge.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 18.0f;
        LatLng tahrirLoungeLocation = new LatLng(30.0457827, 31.2361217);
        mMap.addMarker(new MarkerOptions().position(tahrirLoungeLocation).title("Tahrir Lounge"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tahrirLoungeLocation, zoomLevel));
        UiSettings settings = mMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
    }}