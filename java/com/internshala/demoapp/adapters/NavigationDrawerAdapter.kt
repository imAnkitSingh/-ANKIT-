package com.internshala.demoapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.internshala.demoapp.R

class NavigationDrawerAdapter(_contentList: ArrayList<String>, _getImage: IntArray, _context: Context,onMenuClickListener: onMenuClickListener): RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>()
{
    var contentList: ArrayList<String>? = null
    var get_image: IntArray? = null
    var mContext: Context? = null
    var onMenuClickListener: onMenuClickListener

    init {
        this.contentList = _contentList
        this.get_image = _getImage
        this.mContext = _context
        this.onMenuClickListener=onMenuClickListener
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NavViewHolder {
        var itemView = LayoutInflater.from(p0?.context)
                .inflate(R.layout.row_cutome_navdrawer, p0, false)
        var returnThis = NavViewHolder(itemView)
        return returnThis
    }

    override fun onBindViewHolder(p0: NavViewHolder, p1: Int) {
        p0?.icon_Get?.setBackgroundResource(get_image?.get(p1) as Int)
        p0?.text_Get?.setText(contentList?.get(p1))
        p0?.contentHolder?.setOnClickListener({
            if (p1==0) {
                onMenuClickListener.onImageClick(0)
            }
            else if (p1==1)
            {
                onMenuClickListener.onImageClick(1)
            }
            else
            {
                onMenuClickListener.onImageClick(2)
            }
        })
    }

    override fun getItemCount(): Int {
        return (contentList as ArrayList).size
    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView as View)
    {
        var icon_Get: ImageView? = null
        var text_Get: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            icon_Get = itemView?.findViewById(R.id.icon_navdrawer)
            text_Get = itemView?.findViewById(R.id.text_navdrawer)
            contentHolder = itemView?.findViewById(R.id.navdrawer_item_content_holder)
        }
    }
}

interface onMenuClickListener {
    fun onImageClick(position: Int)
}


