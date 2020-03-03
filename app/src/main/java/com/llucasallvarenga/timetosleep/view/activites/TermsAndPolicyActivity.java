package com.llucasallvarenga.timetosleep.view.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.R;

public class TermsAndPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_policy);

        WebView webView = findViewById(R.id.wbPrivacyAppId);
        ProgressBar progressBar = findViewById(R.id.pbPrivacyAppId);
        Toolbar toolbar = findViewById(R.id.toolbarPrivacyAppId);

        toolbar.setNavigationIcon(R.drawable.ic_help_terms_policy_back);
        toolbar.setNavigationOnClickListener(view -> finish());


        webView.loadUrl("https://timetosleepbr.github.io/privacy_app.html");

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.VISIBLE);
                }

            });

        }else{
            Toast.makeText( TermsAndPolicyActivity.this , "Falha ao conectar-se a rede", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
