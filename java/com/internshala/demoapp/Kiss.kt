package com.internshala.demoapp

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.internshala.demoapp.WebView.WebChromeClt

import kotlinx.android.synthetic.main.activity_kiss.*

@Suppress("DEPRECATION")
class Kiss :  AppCompatActivity() {
    var webView: WebView?=null

    var  progressBar:ProgressBar?=null
    var  progressStatus:Int = 0

    var handler:Handler= Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().requestFeature(Window.FEATURE_PROGRESS)
        setContentView(R.layout.activity_kiss)
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON)
        var toolbarKiss = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbarKiss)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        toolbarKiss.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)

        toolbarKiss.setNavigationOnClickListener({

            onBackPressed()
        })

                webView=findViewById(R.id.kissweb)

        progressBar =findViewById<ProgressBar>(R.id.kissProgressBar)
        Log.d("Kiss",""+ progressBar)
        var webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
        webView?.webChromeClient=  WebChromeClt(this@Kiss,progressBar)
        webView?.loadUrl("https://kiss.ac.in/")
        progressStatus=webView!!.progress



       /* override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
            if (keyCode == KeyEvent.KEYCODE_BACK && this.webView!!.canGoBack()) {
                webView!!.goBack()
                return true
            }

            return super.onKeyDown(keyCode, event)
        }  */
/*
         Thread( Runnable() {


              run() {



                while (progressStatus < 100) {

                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post( Runnable() {
                          run() {
                            progressBar?.setProgress(progressStatus);
                              //textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (e: InterruptedException) {
                        e.printStackTrace();
                    }
                }
            }
        }).start()
*/






    }



}

