package com.internshala.demoapp.ApiClient

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.google.gson.annotations.SerializedName
//import javax.swing.text.AbstractDocument.Content
import com.google.gson.annotations.Expose
//import javax.swing.text.AbstractDocument.Content
//import javax.swing.text.AbstractDocument.Content




//import javax.swing.text.AbstractDocument.Content







 data class Awards(var id:String="",var title: Title?,var excerpt: Excerpt?,var content:Content?,var featuredMedia: Int?) {
 }
/*class Awards
{
    @SerializedName("id")
    @Expose
    private var id:String?=null

    var mlistofid= arrayListOf<String>()

    // var id: Int
    /*      get()
          {
              return id
          }
          set(value) {
              id = value
          } */
    @Expose
    @SerializedName("title")
    private  var title: Title? = null
    @SerializedName("content")
    @Expose
    private var content: Content?=null
    @SerializedName("excerpt")
    @Expose
    private  var excerpt: Excerpt?=null
    @Expose
    private var featuredMedia: Int? = null




    @SerializedName("comment_status")
    fun getId(): String? {

        Log.d("getterinsidefunction","" +id)
        return id
    }
    fun setId(id: String,count:Int) {
        Log.d("setterinsidefunction","" +id)

        this.id = id
        if (count==1)
        {
            mlistofid.add(id)
        }

        else
        {}


            Log.d("setterAfter", "" + this.id)

        Log.d("listOfId", "" + this.mlistofid)




    }

    fun getTitle(): Title? {
        return title
    }
    fun setTitle(title:Title)
    {
        this.title = title
    }

    override fun toString(): String {
        return "Awards{id = $id }"


    }



}  */


























