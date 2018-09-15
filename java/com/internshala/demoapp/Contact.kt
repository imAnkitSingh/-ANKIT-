package com.internshala.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class Contact : AppCompatActivity() {
    var webView: WebView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        webView=findViewById(R.id.webView_Contact)
        webView?.loadUrl("https://achyutasamanta.com/contact-me/")
        webView?.setWebViewClient(WebViewClient())
        var   webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
    }
}
