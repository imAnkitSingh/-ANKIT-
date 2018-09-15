package com.internshala.demoapp

import android.app.ActionBar
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.internshala.demoapp.WebView.WebChromeClt

import kotlinx.android.synthetic.main.activity_art_of_giving.*

class ArtOfGiving :  AppCompatActivity() {
    var webView:WebView?=null
    var  progressBar: ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_of_giving)

        var toolbarArt = findViewById<Toolbar>(R.id.toolbar)
          setSupportActionBar(toolbarArt)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        toolbarArt.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)

        toolbarArt.setNavigationOnClickListener({

            onBackPressed()
        })
        webView=findViewById(R.id.artOfGiving)
        progressBar =findViewById<ProgressBar>(R.id.artProgressBar)
        var webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
        webView?.setWebViewClient(WebViewClient())
        webView?.webChromeClient=  WebChromeClt(this@ArtOfGiving,progressBar)
        webView?.loadUrl("http://artofgiving.in.net/")
    }

}
