package com.internshala.demoapp.ApiClient

//import sun.text.normalizer.UTF16.append
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 data class BlogList (var id:String?,var title: Title?,var content: Content?,var excerpt: Excerpt?)
 {


 }

  /*  @SerializedName("id")
    @Expose
   private var id: String? = null

  /*  @SerializedName("_links")
    @Expose
   private var links: Links? = null */

    @SerializedName("title")
    @Expose
   private var title: Title? = null
    @SerializedName("content")
    @Expose
   private var content: Content? = null
    @SerializedName("excerpt")
    @Expose
   private var excerpt: Excerpt? = null


    fun getTitle(): Title? {
        return title
    }

    fun setTitle(title: Title?) {
        this.title = title
    }

    fun getContent(): Content? {
        return content
    }

    fun setContent(content: Content) {
        this.content = content
    }

    fun getExcerpt(): Excerpt? {
        return excerpt
    }

    fun setExcerpt(excerpt: Excerpt?) {
        this.excerpt = excerpt
    }   */

  /*  fun getLinks(): Links? {
        return links
    }

    fun setLinks(links: Links?) {
        this.links = links
    }

} */