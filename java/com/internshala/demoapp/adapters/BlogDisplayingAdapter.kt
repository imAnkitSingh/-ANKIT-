package com.internshala.demoapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.internshala.demoapp.R
import com.squareup.picasso.Picasso

class BlogDisplayingAdapter(_Id:ArrayList<String>?,_Title:ArrayList<String>?,_Excerpt:ArrayList<String>?,_Content:ArrayList<String>?,
                   _Context: Context?)
    : RecyclerView.Adapter<BlogDisplayingAdapter.NavViewHolder>() {


    var mcontext: Context?=null
    var mId:ArrayList<String>?=null
    var mTitle:ArrayList<String>?=null
    var mExcerpt:ArrayList<String>?=null
    var mContent:ArrayList<String>?=null
    var imageurl:ArrayList<String>?= arrayListOf("https://cdn.achyutasamanta.com/wp-content/uploads/2018/09/Revisiting-a-train-ride-to-Calcutta-Achyuta-Samanta.jpg"
            ,
            "https://cdn.achyutasamanta.com/wp-content/uploads/2018/08/KISS-Students-visit-New-Delhi-KISS-delhi-29-768x576.jpg"
            ,
            "https://cdn.achyutasamanta.com/wp-content/uploads/2018/08/Towards-a-compassionate-work-culture-Achyuta-Samanta-5-768x500.jpg"
            ,"https://cdn.achyutasamanta.com/wp-content/uploads/2018/08/Odisha-Gurupriya-Setu-at-Night-768x408.jpg",
            "https://cdn.achyutasamanta.com/wp-content/uploads/2018/07/Achyuta-Samanta-Blog-Article-1-768x512.jpg"
            ,"https://cdn.achyutasamanta.com/wp-content/uploads/2018/07/Prof.-Achyuta-Samanta-with-his-Mother.jpg")
    init {
        this.mcontext=_Context
        this.mId=_Id
        this.mTitle=_Title
        this.mExcerpt=_Excerpt
        this.mContent=_Content
        Log.d("Adapter",""+mTitle)
    }
    override fun onBindViewHolder(p0: NavViewHolder, p1: Int) {


                try {
                    p0.awardTitle?.setText(mTitle?.get(p1))
                    p0.awardExcerpt?.setText(mExcerpt?.get(p1))

                    //  p0.awardContent?.setText(mContent?.get(p1))
                    var count = 0

                        p0.knowMore?.setOnClickListener({
                            var cp1 = p1

                            if (count==0)
                            {
                                p0.awardExcerpt?.setText(mContent?.get(cp1))
                                count = 1
                            }
                            else
                            {
                                p0.awardExcerpt?.setText(mExcerpt?.get(p1))
                             count = 0
                            }



                        })




                    Picasso.get().load(imageurl?.get(p1)).resize(700,550).into(p0?.img)

                }
                catch (e: Exception)
                {
                    e.printStackTrace()
                }


    }

    override fun getItemCount(): Int {
        if (mId == null ) {
            return 0
        } else {
            return (mId as ArrayList<String>).size
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NavViewHolder {
        var itemView = LayoutInflater.from(p0?.context)
                .inflate(R.layout.row_custome_blog_displaying_adapter, p0, false)
        var returnThis = BlogDisplayingAdapter.NavViewHolder(itemView)
        return returnThis

    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView as View) {
        var mawardBaseContent: RelativeLayout?=null
        var awardTitle: TextView?=null
        var awardContent: TextView?=null
        var awardExcerpt: TextView?=null
        var knowMore: RelativeLayout?=null
        var img: ImageView?=null
        init {
            this.img=itemView?.findViewById(R.id.imgBlog)
            this.knowMore=itemView?.findViewById(R.id.knowMoreBlog)
            this.mawardBaseContent=itemView?.findViewById(R.id.BlogBaseContent)
            this.awardTitle=itemView?.findViewById(R.id.titleBlog)
           // this.awardContent=itemView?.findViewById(R.id.contentAward)
            this.awardExcerpt=itemView?.findViewById(R.id.blogexcerpt)
        }



    }
}