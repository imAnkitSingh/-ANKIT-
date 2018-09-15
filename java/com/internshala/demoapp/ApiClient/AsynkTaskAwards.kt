package com.internshala.demoapp.ApiClient

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.AsyncTask
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.facebook.FacebookSdk.getApplicationContext
import com.internshala.demoapp.AboutActivity
import com.internshala.demoapp.adapters.AwardAdapter
import com.internshala.demoapp.fragments.Award_And_Achievment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//@Suppress("CAST_NEVER_SUCCEEDS")
/*class AsynkTaskAwards() : AsyncTask<String, String, String>()  {

    var mJsonObject:Awards?=null

//list of all the content
        var abc="ABC"
    var mID= arrayListOf<String>()
    var mTitle= arrayListOf<String>()
    var mCOntent= arrayListOf<String>()
    var mEXcerpt= arrayListOf<String>()
    var mMediaAttachment= arrayListOf<String>()




    //pojo Class decleration
    var mcallback:Callback<ArrayList<Awards>>?=null
    var mtitle: Title? = null
    var mContent: Content? = null
    var mid:String?=null
    var titleContent: Title? = null
    //list for class
    var awardsList = arrayListOf<Awards>()
    var titleList: Title? = null
    var contentList: Content? = null
    var excerpt: Excerpt? = null
    var staticClass = arrayListOf<Awards>()
    var count:Int=1

    // staticated adapter
    object Statified
    {

      var  mAwardAdapterr: AwardAdapter?=null
    }
    var  awardRecyclerView:RecyclerView?=null

    override fun onPreExecute() {
        super.onPreExecute()


    }

    override fun doInBackground(vararg p0: String?): String {
    //    awards=Awards()
        var apiInterface = ApiClient.Staticated.getClient().create(APIInterface::class.java)
        var call: Call<ArrayList<Awards>> = apiInterface.doGetUserList()

        // changes are made her eto check the

     //   Toasta.makeText(getApplicationContext(),"Value is" +AboutActivity.Statified.mId,Toast.LENGTH_LONG ).show()


            call.enqueue(object : Callback<ArrayList<Awards>> {
                override fun onResponse(call: Call<ArrayList<Awards>>?, response: Response<ArrayList<Awards>>?) {
                    //  Toast.makeText(this@AboutActivity,"hellow u are here ",Toast.LENGTH_LONG).show()
                    Log.d("AsynkTask", "Server Response: " + response.toString())
                    Log.d("AsynkTask", "ServerBody" + response?.body().toString())

                    for (i in 0 until response?.body()!!.size) {

                        var jsonObject = response?.body()!!.get(i)
                        var arrayList = ArrayList<Awards>()
                 /*       mid = jsonObject.getId()
                        Log.d("background", "" + mid)

                        if (i >= 0) {
                            awards?.setId(mid!!, count!!)
                            Log.d("Outside", "" + awards?.getId())
                            count = 1

                        } else {
                            count == 0
                        } */


                        // AboutActivity.Statified.mId.add(mid as String)

                        //id
                        mid =jsonObject.id

                        mID.add(mid!!)


                        // tiitle
                          var mRendered = jsonObject.title?.rendered

                        //title class value setter
                         var mtitle = Title(mRendered as String)
                        mTitle.add(mRendered)

                        //Ecerpt

                         var renderedExcerpt = jsonObject.excerpt?.rendered

                        // Excerpt class value setter
                         var mExcerpt = Excerpt(renderedExcerpt)
                        mEXcerpt.add(renderedExcerpt!!)

                        //Content
                         var mRenderedContent = jsonObject.content?.rendered

                        // Content class setter
                         mContent = Content(mRenderedContent as String)
                        mCOntent.add(mRenderedContent)

                        // featured media

                         var featuredMedia = jsonObject.featuredMedia

                         awardsList.add(Awards(mid!!, mtitle, mExcerpt, mContent, featuredMedia))


                        // staticClass.add( StaticClass(AboutActivity.Statified.mId))
                        //  staticClass.add(StaticClass().mid)

                    Statified.mAwardAdapterr =AwardAdapter(mID,mTitle,mEXcerpt,mCOntent)


                    }



                }

                override fun onFailure(call: Call<ArrayList<Awards>>?, t: Throwable?) {
                    Log.e("AsynkTask", "Something went wrong error " + t?.printStackTrace())
                    // Toast.makeText(this@AboutActivity,"Something wrong here ", Toast.LENGTH_LONG).show()


                }
            })






        return (abc as String)

    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

          //  AboutActivity.Statified.mId.add(result?.get(i).id  as String)
       // Log.d("onPost",""+result!!.getId())
        //    Toast.makeText(getApplicationContext(),"Value is" + result!!.mlistofid,Toast.LENGTH_LONG).show()

        result

     //   Log.d("onPost",""+awards?.mlistofid)

    }


}  */




/*
    override fun doInBackground(vararg p0: String?): Call<ArrayList<Awards>> {
        var apiInterface = ApiClient.Staticated.getClient().create(APIInterface::class.java)
        var call: Call<ArrayList<Awards>> = apiInterface.doGetUserList()  // changes are made her eto check the

        return call
    }

    override fun onPostExecute(result: Call<ArrayList<Awards>>?) {
        super.onPostExecute(result)
        result?.enqueue(object : Callback<ArrayList<Awards>> {
            override fun onResponse(call: Call<ArrayList<Awards>>?, response: Response<ArrayList<Awards>>?) {
                //  Toast.makeText(this@AboutActivity,"hellow u are here ",Toast.LENGTH_LONG).show()
                Log.d("AsynkTask", "Server Response: " + response.toString())
                Log.d("AsynkTask", "ServerBody" + response?.body().toString())

                for (i in 0 until response?.body()!!.size) {

                    var jsonObject = response?.body()!!.get(i)
                    var arrayList = ArrayList<Awards>()
                    mid = jsonObject.id
                    AboutActivity.Statified.mId.add(mid!!)

                    // tiitle
                    var mRendered = jsonObject.title?.rendered
                    //title class value setter
                    var mtitle = Title(mRendered as String)


                    //Ecerpt

                    var renderedExcerpt = jsonObject.excerpt?.rendered

                    // Excerpt class value setter
                    var mExcerpt = Excerpt(renderedExcerpt)

                    //Content
                    var mRenderedContent = jsonObject.content?.rendered

                    // Content class setter
                    mContent = Content(mRenderedContent as String)

                    // featured media

                    var featuredMedia = jsonObject.featuredMedia

                    awardsList.add(Awards(mid, mtitle, mExcerpt, mContent, featuredMedia))


                }



            }

            override fun onFailure(call: Call<ArrayList<Awards>>?, t: Throwable?) {
                Log.e("AsynkTask", "Something went wrong error " + t?.printStackTrace())
                // Toast.makeText(this@AboutActivity,"Something wrong here ", Toast.LENGTH_LONG).show()


            }
        })
        Toast.makeText(getApplicationContext(),"value"+ AboutActivity.Statified.mId,Toast.LENGTH_LONG).show()

    }




    }  */









