package com.internshala.demoapp.ApiClient

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 data class Content(var rendered:String) {

 }

//}


/* class Content()
{
  @SerializedName("rendered")
    @Expose
   private var rendered: String?= null


    @SerializedName("protected")
    @Expose
    var protected: Boolean? = null

    fun getRendered(): String? {
        return rendered
    }

    fun setRendered(rendered: String) {
        this.rendered = rendered
    }


} */