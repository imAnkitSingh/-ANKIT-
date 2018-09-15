package com.internshala.demoapp.ApiClient

import android.widget.Toast
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*


 public interface APIInterface {

    /* @GET("/wp-json/wp/v2/posts?categories=58")
     fun doGetListResources(): Call<MultipleResource>  */


    /*  @POST("/api/users")
      fun createUser(@Body user: User): Call<User>
      */

    @Headers("Content-type:application/json")
    @GET("/wp-json/wp/v2/posts?categories=58")
   // fun doGetUserList():Call <ArrayList<UserList>>

     fun doGetUserList():Call <ArrayList<Awards>>
     @GET("/wp-json/wp/v2/posts?categories=67")
     fun doGetBlogList():Call<ArrayList<BlogList>>


     @GET("/wp-json/wp/v2/media?parent=2289")
fun doGetImageList():Call<ArrayList<Awards>>



}




