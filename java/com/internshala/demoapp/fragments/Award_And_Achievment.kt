package com.internshala.demoapp.fragments


import android.app.Activity
import android.content.Context
import android.icu.lang.UScript
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.internshala.demoapp.ApiClient.APIInterface
//import com.internshala.demoapp.ApiClient.APIInterface
import com.internshala.demoapp.ApiClient.ApiClient
// import com.internshala.demoapp.ApiClient.GithubApiService
//import com.internshala.demoapp.ApiClient.UserList

import com.internshala.demoapp.R
import retrofit2.Call
import retrofit2.Callback
import android.widget.Toast
import com.internshala.demoapp.AboutActivity
//import com.internshala.demoapp.ApiClient.AsynkTaskAwards
import com.internshala.demoapp.ApiClient.Awards
import com.internshala.demoapp.LoginActivity
import com.internshala.demoapp.adapters.AwardAdapter
import com.internshala.demoapp.adapters.FoundationDisplayAdapter
import kotlinx.android.synthetic.main.fragment_award__and__achievment.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Award_And_Achievment : Fragment(){


    // Store instance variables
    private var title:String?=null
    private var page:Int= 0
    var activity:Activity?=null
    var mawards:Awards?=null
            // copied design
    var globelimage:ImageView?=null
    var globelTitle:TextView?=null
    var globelContent:TextView?=null
    //  variables  contanting params
    var mglobalTitle="GLOBAL RECOGNITIONS"
    var mglobelContent="A visionary social architect who embarked back in 1992" +
            " on a social development mission using education as the strategic medium to eradicate" +
            " poverty and alienation from the surface of the earth, " +
            "a goal envisaged today by global leaders that goes as " +
            "Sustainable Development Goals (SDGs)"

//recylerView decleration


  //  var awardRecyclerView:RecyclerView?=null
    var awards:AwardAdapter?=null
    // values are here
    var fragmentId:Int?=null

    var mawardRecyclerView:RecyclerView?=null

    object Staticated
    {
        fun newAboutInstance(page: Int, title: String): Award_And_Achievment {
            val fragmentAward = Award_And_Achievment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            fragmentAward.setArguments(args)
            return fragmentAward
        }


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments!!.getInt("someInt", 0)
        title = arguments!!.getString("someTitle")


       // fragmentId=mawards?.getId()

        Log.d("awardsFragment",""+ LoginActivity.Statified.mID)


//       awards = AwardAdapter(AboutActivity.Statified.mId,AboutActivity.Statified.mTitle,AboutActivity.Statified.mExcert
  //              ,AboutActivity.Statified.mContent)
     //   awardRecyclerView?.layoutManager = LinearLayoutManager(activity as Context)
      //  awardRecyclerView?.itemAnimator = DefaultItemAnimator()
    //    awardRecyclerView?.adapter = AsynkTaskAwards.Statified.mAwardAdapterr





        //val apiService = GithubApiService.create()
        //  var call:Call<UserList> =  apiService.search("id","title","content","excerpt","featured_media")






    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_award__and__achievment, container, false)

        mawardRecyclerView =view.findViewById<RecyclerView>(R.id.awardRecyclerView)
        globelimage=view.findViewById(R.id.globel)
        globelTitle=view.findViewById(R.id.achievmentTitle)
        globelContent=view?.findViewById(R.id.achievmentcontent)


        return view

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity=context as Activity
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        this.activity = activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

      //  awards = AwardAdapter(LoginActivity.Statified.mID,LoginActivity.Statified.mTitle
       //         ,LoginActivity.Statified.mEXcerpt,LoginActivity.Statified.mCOntent,activity)

        var achievment:FoundationDisplayAdapter =FoundationDisplayAdapter(activity as Context)
        achievment?.notifyDataSetChanged()
        mawardRecyclerView?.adapter = achievment
        mawardRecyclerView?.layoutManager = LinearLayoutManager(activity,OrientationHelper.HORIZONTAL,false)
        mawardRecyclerView?.itemAnimator = DefaultItemAnimator()

        this.globelimage?.setBackgroundResource(R.drawable.globelrecognization)
        this.globelTitle?.setText(mglobalTitle)
        this.globelContent?.setText(mglobelContent)




    }

    override fun onResume() {
        super.onResume()
      /*  awards = AwardAdapter(LoginActivity.Statified.mID,LoginActivity.Statified.mTitle
                ,LoginActivity.Statified.mEXcerpt,LoginActivity.Statified.mCOntent,activity)
        awards?.notifyDataSetChanged()
        mawardRecyclerView?.adapter = awards
        mawardRecyclerView?.layoutManager = LinearLayoutManager(activity)
        mawardRecyclerView?.itemAnimator = DefaultItemAnimator()
*/

    }



}
