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
import com.internshala.demoapp.fragments.Foundation

import kotlinx.android.synthetic.main.activity_kiit.*

class Kiit :  AppCompatActivity() {
    var webView: WebView?=null
    var  progressBar: ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiit)
        var toolbarKiit = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbarKiit)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
       toolbarKiit.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)


        toolbarKiit.setNavigationOnClickListener({

            onBackPressed()
        })


        webView=findViewById(R.id.kiitweb)
        progressBar =findViewById<ProgressBar>(R.id.kiitProgressBar)
        var webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
        webView?.setWebViewClient(WebViewClient())
        webView?.webChromeClient=  WebChromeClt(this@Kiit,progressBar)
        webView?.loadUrl("http://kiit.ac.in/")

    }



}
