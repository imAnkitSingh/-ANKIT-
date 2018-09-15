package com.internshala.demoapp.adapters

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.internshala.demoapp.R
import com.squareup.picasso.Picasso


class PageDisplayingAdapter(pageMsg:ArrayList<String>,pageIdd:ArrayList<String>, pageDateOfCreation:ArrayList<String>,
                            pageFullPic:ArrayList<String>,pageStory:ArrayList<String>, mShares:ArrayList<String>,
                            mCommentmsg:ArrayList<String>,mActionLink:ArrayList<String>,context:Context,onButtonClickListener: onButtonClickListener):RecyclerView.Adapter<PageDisplayingAdapter.MyViewHolderr>()

{

     var _Pagemsg:ArrayList<String>?=null
     var _Pageid:ArrayList<String>?=null
     var _PagedateOfCreation:ArrayList<String>?=null
     var mPageContext: Context?=null
     var _PagefullPic:ArrayList<String>?=null
     var _PageStory:ArrayList<String>?=null
     var _Shares:ArrayList<String>?=null
     var _Commentmsg:ArrayList<String>?=null
     var _ActionLink:ArrayList<String>?=null
     var onButtonClickListener: onButtonClickListener
     init {
         this._Pagemsg= pageMsg
         this._Pageid=pageIdd
         this._PagedateOfCreation=pageDateOfCreation
         this.mPageContext=context
         this._PagefullPic=pageFullPic
         this._PageStory=pageStory
         this._Shares =mShares
         this._Commentmsg=mCommentmsg
         this._ActionLink=mActionLink
         this.onButtonClickListener=onButtonClickListener

     }



     override fun onBindViewHolder(p0: MyViewHolderr, p1: Int) {

         try {
               var mPageDisplayingContentMsg = _Pagemsg?.get(p1)
              var mPageDisplayingContentStory=_PageStory?.get(p1)
         //    var mPageDisplayingContentDateOfCreation=_PagedateOfCreation?.get(p1)

       //      Picasso.get().load(mPagephotoArrangment).into(p0?.mPagePhoto)

             p0?.mPageCreatedTime?.setText(_PagedateOfCreation?.get(p1))
             p0?.mPageStory?.setText(_PageStory?.get(p1))
           //  p0?.mPageCreatedTime?.setText(_PagedateOfCreation?.get(p1))
           //  p0?.mPageStory?.setText(_PageStory?.get(p1))

             // holder?.mShareCount?.setText(_Shares?.get(position))

         }

         catch (e: Exception)
         {
             e.printStackTrace()
         }
         var mPagephotoArrangment=_PagefullPic?.get(p1)
         if(mPagephotoArrangment=="")
         {
            p0?.mPagePhoto?.visibility=View.INVISIBLE
         }
         else {
             p0?.mPagePhoto?.visibility=View.VISIBLE
             Picasso.get().load(mPagephotoArrangment).into(p0?.mPagePhoto)

         }

         p0?.pageMessage?.setText(_Pagemsg?.get(p1))
         p0?.mPagePostContainer?.setOnClickListener({
             onButtonClickListener.onImageClick(_ActionLink as ArrayList<String>,p1)
         })
     }

     override fun getItemCount(): Int {
         if (_Pageid == null ) {
             return 0
         } else {
             return (_Pageid as ArrayList<String>).size
         }
     }

     override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolderr {
         var itemView = LayoutInflater.from(p0?.context)
                 .inflate(R.layout.row_custome_page_displayy, p0, false)
         return MyViewHolderr(itemView)
     }

     class MyViewHolderr(view:View) : RecyclerView.ViewHolder(view) {
         var pageMessage:TextView?=null
         var mPageCreatedTime:TextView?=null
         var mPagePhoto:ImageView?=null
         var mPageStory:TextView?=null
         var mPagePostContainer:RelativeLayout?=null
         init {
             this.pageMessage=view.findViewById(R.id.pageMessage)
             this.mPageCreatedTime=view.findViewById(R.id.pageDOC)
             this.mPagePhoto=view.findViewById(R.id.pageImage)
            this.mPagePostContainer=view.findViewById(R.id.pageBaseContent)
             this.mPageStory=view.findViewById(R.id.pageStory)

         }
     }




}
interface onButtonClickListener {
    fun onImageClick(_mActionLink: ArrayList<String>,position: Int)
}

