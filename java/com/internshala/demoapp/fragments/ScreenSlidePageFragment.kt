package com.internshala.demoapp.fragments


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.internshala.demoapp.LoginActivity
import com.internshala.demoapp.R
import com.internshala.demoapp.adapters.AwardAdapter
import com.internshala.demoapp.adapters.BlogDisplayingAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ScreenSlidePageFragment : Fragment() {

    private var title: String? = null
    private var page: Int = 0
    var webView:WebView?=null

    //recyclerView DEcleration

   var mBlogRecyclerView:RecyclerView?=null
    // Blog Adapter decleration
  var  mBlogDisplayingAdapter:BlogDisplayingAdapter?=null

    // Activity context
    var activity:Activity?=null


    // newInstance constructor for creating fragment with arguments
    object Staticated
    {
        fun newInstance(page: Int, title: String): ScreenSlidePageFragment {
            val fragmentThird = ScreenSlidePageFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            fragmentThird.setArguments(args)
            return fragmentThird
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments!!.getInt("someInt", 0)
        title = arguments!!.getString("someTitle")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
       //  webView= view.findViewById<WebView>(R.id.news)
         mBlogRecyclerView=view?.findViewById(R.id.blogRecyclerView)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    /*    webView?.loadUrl("https://achyutasamanta.com/")
//        var   webSettings: WebSettings = webView?.getSettings() as WebSettings
//      webSettings.setJavaScriptEnabled(true)
        webView?.setWebViewClient(WebViewClient())  */
 /* while(LoginActivity.Statified.mfalseLoop==1) {


    LoginActivity.Statified.mfalseLoop=0
 }  */
        FalseLooping()




    }

    fun FalseLooping()
    {



            Log.d("Inside while loop",""+ LoginActivity.Statified.mIDBlog)




    }

    override fun onResume() {
        super.onResume()
        mBlogDisplayingAdapter = BlogDisplayingAdapter(LoginActivity.Statified.mIDBlog, LoginActivity.Statified.mTitleBlog
                , LoginActivity.Statified.mEXcerptBlog, LoginActivity.Statified.mCOntentBlog, activity)
        mBlogDisplayingAdapter?.notifyDataSetChanged()
        mBlogRecyclerView?.adapter = mBlogDisplayingAdapter
        mBlogRecyclerView?.layoutManager = LinearLayoutManager(activity)
        mBlogRecyclerView?.itemAnimator = DefaultItemAnimator()
    }
}
