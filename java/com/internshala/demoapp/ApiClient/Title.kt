package com.internshala.demoapp.ApiClient

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 data class Title(var rendered:String) {
 }
/*
class Title {


  @SerializedName("rendered")
  @Expose
  private var rendered: String? = null

  fun getRendered(): String? {
   return this.rendered
  }

  fun setRendered(rendered: String?) {
   this.rendered = "hellow"
  }

  override fun toString(): String {
   return "Title{rendered= $rendered }"
  }
 }*/






