package com.internshala.demoapp.fragments


import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.*
import com.facebook.FacebookSdk.getApplicationContext
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.internshala.demoapp.adapters.PageDisplayingAdapter
import com.internshala.demoapp.PageLike
import com.internshala.demoapp.R
import com.internshala.demoapp.adapters.onButtonClickListener
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList
import com.facebook.GraphResponse
import com.facebook.GraphRequest
import retrofit2.http.GET
import com.facebook.AccessToken






// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FacebookPageFragment : Fragment(), onButtonClickListener {
    override fun onImageClick(_mActionLink: ArrayList<String>, position: Int) {
        val i=Intent(myActivity, PageLike::class.java)
        i.putExtra("likeLinks",_mActionLink)
        i.putExtra("position",position)
        startActivity(i)
        (activity as Activity).overridePendingTransition(0, 0)

    }

    // Store instance variables
    private var title: String? = null
    private var page: Int = 0
    var myActivity:Activity?=null
    var callbackManager:CallbackManager?=null
// variables decleared Globally
var pageMessage: String? = null
    var pageStory: String? = null
    var pageId: String? = null
    var pagePic: String? = null
    var pageDOC: String? = null
    var pageComents: String? = null
    var pageLikes: String? = null
    var pageShare: String? = null
    var mCount: String? = null
    var mCommentMessage: String? = null
    var mCommentCreateTime: String? = null
    var mCommentId: String? = null
    var mactions: String? = null
    var mActionName: String? = null
    var allActionName = arrayListOf<String>()

    var mActionLink: String? = null
    var allActionLink = arrayListOf<String>()
    var mNameComment: String? = null
    var mComentLink: String? = null
    var mallCommentMessage = arrayListOf<String>()
    var mallCommentCreateTime = arrayListOf<String>()
    var mallCommentId = arrayListOf<String>()
    var allPageMessage = arrayListOf<String>()
    var allPageStory = arrayListOf<String>()
    var allPageId = arrayListOf<String>()
    var allPagePic = arrayListOf<String>()
    var allpageDoc = arrayListOf<String>()
    var allpageComents = arrayListOf<String>()
    var allPageLikes = arrayListOf<String>()
    var allPageShares = arrayListOf<String>()
    var allCreatedDate= arrayListOf<String>()
    //page Displaying adapters
    var pageDisplayingAdapters: PageDisplayingAdapter?=null
    //recycler View
  var  pageDisplayRecyclerView:RecyclerView?=null

    // newInstance constructor for creating fragment with arguments
    object Staticated
    {
        fun newInstance(page: Int, title: String): FacebookPageFragment {
            val fragmentFirst = FacebookPageFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            fragmentFirst.setArguments(args)
            return fragmentFirst
    }

    }
  /*  override fun onImageClick(_mActionLink: ArrayList<String>,position:Int) {
        var i:Intent =Intent(baseContext,LikeActivity::class.java)
        i.putExtra("likeLinks",_mActionLink)
        i.putExtra("position",position)
        startActivity(i)
        //  Toast.makeText(baseContext,""+ _mActionLink.size,Toast.LENGTH_LONG).show()
    }  */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // facebook Sdk
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(myActivity)

        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().logInWithPublishPermissions(
                this,
                Arrays.asList("manage_pages", "publish_pages"
                ))

        // for View pager
        page = arguments!!.getInt("someInt", 0)
        title = arguments!!.getString("someTitle")

        /* make the API call */

/* make the API call */





        var mRequest: GraphRequest = GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/769268423274829/feed?fields=full_picture,id,message,story," +
                        "created_time,comments{comment_count,created_time,message},shares,actions",
                null,
                HttpMethod.GET,
         GraphRequest.Callback { response: GraphResponse? ->
             Log.d(TAG, response.toString())

             var jsonResponse1: JSONObject = response!!.getJSONObject()
             var jsonArray1: JSONArray = jsonResponse1.getJSONArray("data")


             for (i in 0 until jsonArray1.length()) {
                 var jsonObject1: JSONObject = jsonArray1.getJSONObject(i)
                 if (jsonObject1.has("message")) {
                     pageMessage = jsonObject1.optString("message")
                     allPageMessage.add(pageMessage as String)

                 } else {
                     pageMessage = ""
                     allPageMessage.add(pageMessage as String)
                 }

                 if (jsonObject1.has("id")) {
                     pageId = jsonObject1.optString("id")
                     allPageId.add(pageId as String)
                 } else {
                     pageId = ""
                     allPageId.add(pageId as String)
                 }
                 if (jsonObject1.has("story")) {
                     pageStory = jsonObject1.optString("story")
                     allPageStory.add(pageStory as String)
                 } else {
                     pageStory = ""
                     allPageStory.add(pageStory as String)
                 }
                 if (jsonObject1.has("full_picture")) {
                     pagePic = jsonObject1.optString("full_picture")
                     allPagePic.add(pagePic as String)
                 } else {
                     pagePic = ""
                     allPagePic.add(pagePic as String)
                 }
                 if (jsonObject1.has("created_time")) {
                     pageDOC = jsonObject1.optString("created_time")
                     allpageDoc.add(pageDOC as String)
                 } else {
                     pageDOC = ""
                     allpageDoc.add(pageDOC as String)
                 }
                 if (jsonObject1.has("shares")) {
                     var response2: JSONObject = jsonObject1.getJSONObject("shares")
                     mCount = response2.getString("count")
                     allPageShares.add(mCount as String)
                 } else {
                     mCount = "0"
                     allPageShares.add(mCount as String)
                 }
                 if (jsonObject1.has("comments")) {
                     var response3: JSONObject = jsonObject1.getJSONObject("comments")
                     var jsonArray2: JSONArray = response3.getJSONArray("data")
                     for (j in 0 until jsonArray2.length()) {
                         var response4: JSONObject = jsonArray2.getJSONObject(j)
                         if (response4.has("message")) {
                             mCommentMessage = response4.getString("message")
                             mallCommentMessage.add(mCommentMessage as String)

                         } else {
                             mCommentMessage = ""
                             mallCommentMessage.add(mCommentMessage as String)
                         }
                         if (response4.has("created_time")) {
                             mCommentCreateTime = response4.getString("created_time")
                             mallCommentMessage.add(mCommentMessage as String)
                         } else {
                             mCommentCreateTime = ""
                             mallCommentCreateTime.add(mCommentCreateTime as String)

                         }
                         if (response4.has("id")) {
                             mCommentId = response4.getString("id")
                             mallCommentId.add(mCommentId as String)
                         } else {
                             mCommentId = ""
                             mallCommentId.add(mCommentId as String)
                         }
                     }
                 }
                 if (jsonObject1.has("actions")) {
                     var jsonArray3: JSONArray = jsonObject1.getJSONArray("actions")
                     //  var response5:JSONObject =jsonObject1?.getJSONObject("actions")
                     for (k in 0 until jsonArray3.length()) {
                         var response5: JSONObject = jsonArray3.getJSONObject(k)
                         if (k == 0) {

                             mActionName = response5.getString("name")
                             allActionName.add(mActionName as String)
                             mActionLink = response5.getString("link")
                             allActionLink.add(mActionLink as String)

                         }
                     }
                 }
             }


       }





        )
        var parm = Bundle()
        parm.putString("fields", "full_picture,message,actions,id,story,created_time,comments{comment_count,created_time,message},shares")
        mRequest.parameters = parm
        mRequest.executeAsync()



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var  view =inflater.inflate(R.layout.fragment_facebook_page, container, false)
        pageDisplayRecyclerView=view.findViewById(R.id.pageRecyclerView)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        myActivity=context as Activity
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        myActivity=activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    //    Toast.makeText(getApplicationContext(),"size"+ allPageMessage.size,Toast.LENGTH_LONG).show()
        pageDisplayingAdapters = PageDisplayingAdapter(allPageMessage, allPageId, allpageDoc,
                allPagePic, allPageStory, allPageShares, mallCommentMessage, allActionLink, myActivity as Context, this)
        pageDisplayingAdapters?.notifyDataSetChanged()
        pageDisplayRecyclerView?.layoutManager = LinearLayoutManager(myActivity as Context)
        pageDisplayRecyclerView?.itemAnimator = DefaultItemAnimator()
        pageDisplayRecyclerView?.adapter = pageDisplayingAdapters
    }


    override fun onResume() {
        super.onResume()
        pageDisplayingAdapters = PageDisplayingAdapter(allPageMessage, allPageId, allpageDoc,
                allPagePic, allPageStory, allPageShares, mallCommentMessage, allActionLink, myActivity as Context, this)
        pageDisplayingAdapters?.notifyDataSetChanged()
        pageDisplayRecyclerView?.layoutManager = LinearLayoutManager(myActivity as Context)
        pageDisplayRecyclerView?.itemAnimator = DefaultItemAnimator()
        pageDisplayRecyclerView?.adapter = pageDisplayingAdapters
    }



}
