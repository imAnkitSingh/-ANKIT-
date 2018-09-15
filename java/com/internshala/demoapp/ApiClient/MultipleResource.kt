package com.internshala.demoapp.ApiClient

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MultipleResource
{
    @SerializedName("wp:featuredmedia")
    @Expose
    private var wpFeaturedmedia: List<String>? = null
    @SerializedName("wp:attachment")
    @Expose
    private var wpAttachment: List<String>? = null


    fun getWpFeaturedmedia(): List<String>? {
        return wpFeaturedmedia
    }

    fun setWpFeaturedmedia(wpFeaturedmedia: List<String>) {
        this.wpFeaturedmedia = wpFeaturedmedia
    }

    fun getWpAttachment(): List<String>? {
        return wpAttachment
    }

    fun setWpAttachment(wpAttachment: List<String>) {
        this.wpAttachment = wpAttachment
    }

}