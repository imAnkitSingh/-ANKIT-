package com.internshala.demoapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.webkit.WebView
import android.webkit.WebViewClient
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import bolts.Task.call
import com.internshala.demoapp.ApiClient.*
//import com.internshala.demoapp.ApiClient.UserList
import com.internshala.demoapp.adapters.AboutSlidePagerAdapter
import com.internshala.demoapp.adapters.AwardAdapter
import com.internshala.demoapp.adapters.ScreenSlidePagerAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("CAST_NEVER_SUCCEEDS")
class AboutActivity : AppCompatActivity() {
    // var webView: WebView?=null

    var mPager: ViewPager? = null
    var tag: String = "about activity"

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    var mPagerAdapter: PagerAdapter? = null

    //here are the my decleration for display contents

    //pojo Class decleration
    var awards: Awards? = null
    var mtitle: Title? = null
    var mContent: Content? = null
    var mid: String? = null
    var titleContent: Title? = null
    //list for class
    var awardsList = arrayListOf<Awards>()
    var titleList: Title? = null
    var contentList: Content? = null
    var excerpt: Excerpt? = null


    var mAward: Awards? = null
    // var asynkTaskAwards: AsynkTaskAwards? = null
    var count: Int? = 1

    //mRecycler view decleration
    var mRecyclerView: RecyclerView? = null

    //new logic's declearation


    //new adapter decleration

    var mAwardAdapterr: AwardAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  mRecyclerView=findViewById(R.id.recyclerViewAbout)


        overridePendingTransition(0, 0)
        setContentView(R.layout.activity_about)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener({

            onBackPressed()
        })
        // Log.d("About",""+ LoginActivity.Statified.mID)
        mPager = findViewById(R.id.pagerAbout)
        mPager?.setClipToPadding(false);
        mPager?.setPageMargin(50)
        mPagerAdapter = AboutSlidePagerAdapter(this, supportFragmentManager)
        mPager?.setAdapter(mPagerAdapter)


    }
}