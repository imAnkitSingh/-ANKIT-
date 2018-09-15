package com.internshala.demoapp

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

import kotlinx.android.synthetic.main.activity_donate.*

class Donate :  AppCompatActivity() {

    var webView: WebView?=null
    var  progressBar: ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        var toolbarDonate = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbarDonate)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        toolbarDonate.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)

        toolbarDonate.setNavigationOnClickListener({

            onBackPressed()
        })

        webView=findViewById(R.id.donateweb)
        progressBar =findViewById<ProgressBar>(R.id.donateProgressBar)
        var webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
        webView?.setWebViewClient(WebViewClient())
        webView?.webChromeClient=  WebChromeClt(this@Donate,progressBar)
        webView?.loadUrl("https://kiss.ac.in/donate/")

    }


}
