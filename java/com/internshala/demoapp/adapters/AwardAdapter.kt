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
import java.net.URL

class AwardAdapter(_Id:ArrayList<String>?,_Title:ArrayList<String>?,_Excerpt:ArrayList<String>?,_Content:ArrayList<String>?,
                   _Context:Context?)
    : RecyclerView.Adapter<AwardAdapter.NavViewHolder>() {
  var mcontext:Context?=null
   var mId:ArrayList<String>?=null
    var mTitle:ArrayList<String>?=null
    var mExcerpt:ArrayList<String>?=null
    var mContent:ArrayList<String>?=null
    var imageurl:ArrayList<String>?= arrayListOf("https:/cdn.achyutasamanta.com/wp-content/uploads/2018/04/University-of-Cambodia-Honours-Achyuta-Samanta.jpg",
            "https:/cdn.achyutasamanta.com/wp-content/uploads/2018/04/FB_IMG_1522672464620-e1522856971476.jpg",
            "https:/cdn.achyutasamanta.com/wp-content/uploads/2018/04/IMG-20180326-WA0038.jpg","https://achyutasamanta.com/wp-content/uploads/2018/02/Prof.-Achyuta-Samanta-reeiving-the-Honorary-D.Sc_.-Award-from-Berhampur-University.jpg")
    init {
        this.mcontext=_Context
        this.mId=_Id
        this.mTitle=_Title
        this.mExcerpt=_Excerpt
        this.mContent=_Content
        Log.d("Adapter",""+mContent?.size)
    }
    override fun onBindViewHolder(p0: NavViewHolder, p1: Int) {

      //  var mimgUrl =
        try {
            p0.awardTitle?.setText(mTitle?.get(p1))
            p0.awardExcerpt?.setText(mExcerpt?.get(p1))

          //  p0.awardContent?.setText(mContent?.get(p1))
            Picasso.get().load(imageurl?.get(p1)).resize(700,550).into(p0?.img)
            var count = 0

            p0.knowMore?.setOnClickListener({
                var cp1 =p1
                if (count==0)
                {
                    p0.awardExcerpt?.setText(mContent?.get(cp1))
                    count=1
                }
                else
                {
                    p0.awardExcerpt?.setText(mExcerpt?.get(p1))
                  count=0
                }


            })

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
                .inflate(R.layout.row_custome_award, p0, false)
        var returnThis = AwardAdapter.NavViewHolder(itemView)
        return returnThis

    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView as View) {
        var mawardBaseContent:RelativeLayout?=null
        var awardTitle:TextView?=null
        var awardContent:TextView?=null
        var awardExcerpt:TextView?=null
        var knowMore:RelativeLayout?=null
        var img:ImageView?=null
        init {
            this.img=itemView?.findViewById(R.id.imgAward)
            this.knowMore=itemView?.findViewById(R.id.knowMore)
            this.mawardBaseContent=itemView?.findViewById(R.id.awardBaseContent)
            this.awardTitle=itemView?.findViewById(R.id.titleAward)
        //    this.awardContent=itemView?.findViewById(R.id.contentAward)
            this.awardExcerpt=itemView?.findViewById(R.id.awardexcerpt)
        }



    }
}