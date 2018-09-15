package com.internshala.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Notifications : AppCompatActivity() {
    var webView: WebView?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        setContentView(R.layout.activity_notifications)
        webView=findViewById(R.id.webView_Notification)
        webView?.loadUrl("https://achyutasamanta.com/category/testimonials/")
        webView?.setWebViewClient(WebViewClient())
    }
}
