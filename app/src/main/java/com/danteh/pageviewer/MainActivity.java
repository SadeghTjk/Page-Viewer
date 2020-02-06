package com.danteh.pageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;
    int i=0;

    public final static String TAG = "webview";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.wv);
        editText = findViewById(R.id.et);
        final String[] urls = {"https://www.all.ir/","https://www.all.ir/%d8%b3%d8%a7%d9%86%d8%af%d8%a8%d8%a7%d8%b1-%d8%b3%d8%a7%d9%85%d8%b3%d9%88%d9%86%da%af-hw-j7591/","https://www.google.com/"};
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                Log.e(TAG, "onPageFinished: LOADED" );


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(MainActivity.this,"یک امتیاز اضافه شد!",Toast.LENGTH_SHORT).show();
                            if(i<urls.length){
                                webView.loadUrl(urls[i]);
                                i++;
                            }
                        }

                    },5000);
                }
            });
        webView.loadUrl(urls[i]);
        i++;

    }
}
