package com.internshala.demoapp.WebView

import android.app.Activity
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar
import java.util.logging.Handler

class WebChromeClientKiit internal constructor(private val activity: Activity, private var mprogress: ProgressBar?): WebChromeClient()
{
    var mhandler : Handler?=null



    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)

        // Activities and WebViews measure progress with different scales.
        // The progress meter will automatically disappear when we reach 100%


//        activity.setProgress(newProgress * 100)
        mprogress?.setProgress(newProgress *100)
        if ( newProgress==100)
        {
            mprogress?.visibility= View.INVISIBLE
        }
        Log.d("webChromeClient",""+ activity)
        Log.d("webChromeClient",""+ mprogress)

    }

}