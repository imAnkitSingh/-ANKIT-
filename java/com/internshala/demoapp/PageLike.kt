package com.internshala.demoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.share.widget.LikeView
import com.facebook.share.widget.ShareDialog

class PageLike : Activity() {
    var webView: WebView?=null
    // var btnLike: LikeView?=null
    var callbackManager: CallbackManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_like)
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this)
        webView=findViewById(R.id.webView)


        var inBundle:Bundle=intent.extras
        var likeLink=inBundle.getStringArrayList("likeLinks")
        var mposition=inBundle.getInt("position")
        webView?.loadUrl(likeLink.get(mposition))
        var   webSettings: WebSettings = webView?.getSettings() as WebSettings
        webSettings.setJavaScriptEnabled(true)
        webView?.setWebViewClient(WebViewClient())

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}
