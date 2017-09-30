package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafa.tahrirlounge.R;


/**
 * Created by Mostafa on 8/28/2017.
 */

public class AboutApp extends Fragment {
    View myView;
     TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_about_app, container, false);
        textView1=(TextView) myView.findViewById(R.id.textView_of_about_app_1);
        textView2=(TextView) myView.findViewById(R.id.textView_of_about_app_2);
        textView3=(TextView) myView.findViewById(R.id.textView_of_about_app_3);
        textView4=(TextView) myView.findViewById(R.id.textView_of_about_app_4);
        return myView;
    }
}
