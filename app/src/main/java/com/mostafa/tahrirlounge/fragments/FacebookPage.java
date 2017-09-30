package com.mostafa.tahrirlounge.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mostafa.tahrirlounge.R;


public class FacebookPage extends Fragment {

    public static WebView webView;
    ProgressDialog progress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = (View) inflater.inflate(R.layout.fragment_facebook_page, container, false);//CHANGE
        WebView webView = (WebView)mainView.findViewById(R.id.webview);//change
        webView.getSettings().setJavaScriptEnabled(true);
        progress = ProgressDialog.show(getActivity(), null,
                "Loading ...", true);
        webView.loadUrl("https://www.facebook.com/TahrirLounge/");//CHANGE
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                if (progress != null)
                    progress.dismiss();
            }
        });
        return mainView;
    }
}
//TODO Extract resources for remains xml files
// TODO Handle disconnected to internet network
//TODO caching

