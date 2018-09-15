package com.internshala.demoapp

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import com.internshala.demoapp.ApiClient.APIInterface
import com.internshala.demoapp.ApiClient.ApiClient
import com.internshala.demoapp.ApiClient.BlogList
import com.internshala.demoapp.ApiClient.Title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList
import android.content.DialogInterface



class SplashActivity : AppCompatActivity() {

    var permissionString =
            arrayOf(Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.PROCESS_OUTGOING_CALLS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (!haspermission(this@SplashActivity, *permissionString)) {
            // here i called the requestPermissions function for requesting the required permisiion
            ActivityCompat.requestPermissions(this@SplashActivity, permissionString, 131)
        } else {

            if (checkInternetConnectivitySplash()) {

                apiBlog()
                Handler().postDelayed({
                    var startAct = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(startAct)
                    this.finish()
                }, 2000)
            }
            else
            {
            alertMessage()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            131 -> {
                if (grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[2] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[5] == PackageManager.PERMISSION_GRANTED) {

                    if (checkInternetConnectivitySplash()) {
                        apiBlog()
                        Handler().postDelayed({

                            var startAct = Intent(this@SplashActivity, LoginActivity::class.java)
                            startActivity(startAct)
                            this.finish()
                        }, 1000)
                    }
                    else
                    {
                        alertMessage()
                    }

                } else {
                    Toast.makeText(this@SplashActivity, "please grant all permission", Toast.LENGTH_SHORT).show()

                    this.finish()
                }
                return
            }

            else -> {
                Toast.makeText(this@SplashActivity, "something went wrong", Toast.LENGTH_SHORT).show()
                this.finish()
                return
            }
        }
    }

        fun haspermission(context: Context, vararg permissions: String): Boolean {
            var haspermission = true
            for (permission in permissions) {
                var res = context.checkCallingOrSelfPermission(permission)
                if (res != PackageManager.PERMISSION_GRANTED) {

                    haspermission = false
                }
            }
            return haspermission
        }

     override fun onStart() {
        super.onStart()
    }

    fun checkInternetConnectivitySplash():Boolean
    {
       var connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       var networkInfo =connectivityManager?.activeNetworkInfo
        return networkInfo !=null && networkInfo!!.isConnected ()
    }
    fun apiBlog(){
        try {
            var apiInterface = ApiClient.Staticated.getClient().create(APIInterface::class.java)
            var callBlog: Call<ArrayList<BlogList>> = apiInterface.doGetBlogList()

            callBlog.enqueue(object : Callback<ArrayList<BlogList>>
            {
                override fun onResponse(call: Call<ArrayList<BlogList>>?, response: Response<ArrayList<BlogList>>?) {
                    Log.d("BlogApi", "Server Response: " + response.toString())
                    Log.d("BlogApi", "ServerBody" + response?.body().toString())

                    for (i in 0 until response?.body()!!.size) {

                        var jsonObjectBlog = response?.body()!!.get(i)

                        // AboutActivity.Statified.mId.add(mid as String)

                        //id
                        var midBlog = jsonObjectBlog.id

                        LoginActivity.Statified.mIDBlog.add(midBlog!!)


                        // tiitle
                        var mRenderedBlog = jsonObjectBlog.title?.rendered

                        //title class value setter
                        var mtitleBlog = Title(mRenderedBlog as String)
                        LoginActivity.Statified.mTitleBlog.add(mRenderedBlog)

                        //Ecerpt

                        var renderedExcerptBlog = jsonObjectBlog.excerpt?.rendered

                        // Excerpt class value setter
                        //   var mExcerpt = Excerpt(renderedExcerpt)
                        LoginActivity.Statified.mEXcerptBlog.add(renderedExcerptBlog!!)

                        //Content
                        var mRenderedContentBlog = jsonObjectBlog.content?.rendered

                        // Content class setter
                        // var mContent = Content(mRenderedContent as String)

                        LoginActivity.Statified.mCOntentBlog.add(mRenderedContentBlog!!)


                    }

                }

                override fun onFailure(call: Call<ArrayList<BlogList>>?, t: Throwable?) {
                    Log.e("BlogApi", "Something went wrong error " + t?.printStackTrace())
                }


            })

        }
        catch (e: Exception )
        {
            e.printStackTrace()

        }


    }
    fun alertMessage(){

        var  alertDialog= AlertDialog.Builder(this).create()
        (alertDialog as AlertDialog)?.setTitle("Message")
        (alertDialog as AlertDialog)?.setMessage("Please check your \n Internet  Connection")

        alertDialog.setButton("OK") { dialog, which ->
            // Write your code here to execute after dialog closed
            this.finish()
        }
        alertDialog.show()
    }



}