package com.internshala.demoapp.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.internshala.demoapp.fragments.FacebookPageFragment
import com.internshala.demoapp.fragments.ScreenSlidePageFragment
import com.internshala.demoapp.fragments.twitterPageFragment

@Suppress("CAST_NEVER_SUCCEEDS")
class ScreenSlidePagerAdapter (context: Context,fm: FragmentManager?): FragmentPagerAdapter(fm) {
    var NUM_ITEMS: Int = 3
    var mContext: Context? = null
    var mFm: FragmentManager? = null

    init {
        this.mContext = context
        this.mFm = fm
    }

    override fun getCount(): Int {

        return NUM_ITEMS

    }

    override fun getItem(p0: Int): Fragment {


        when (p0) {
            0 // Fragment # 0 - This will show FirstFragment
            -> return (FacebookPageFragment.Staticated.newInstance(0, "Facebook"))
            1 // Fragment # 0 - This will show FirstFragment different title
            -> return (twitterPageFragment.Staticated.newInstance(1, "Twitter"))
            2 // Fragment # 1 - This will show SecondFragment
            -> return (ScreenSlidePageFragment.Staticated.newInstance(2, "Blogs"))

            else -> return null!!


        }

    }

    override fun getPageTitle(position: Int): CharSequence? {

        if (position == 0) {
            return "Facebook"
        }
        else if(position==1) {
            return "Twitter"

        }
        else
        {
            return "Blog"
        }
    }

    override fun getPageWidth(position: Int): Float {
        return 1.00f
    }
}

//o.93



 /*
  var  mSlides:ArrayList<Int>?=null
   var mContext:Context?=null
    var layoutInflater:LayoutInflater?=null
    init {
        this.mSlides =_Slides
        this.mContext
        if (layoutInflater!=null) {
            layoutInflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        else
        {
//            Toast.makeText(mContext,"Empty",Toast.LENGTH_LONG).show()
        }
    }

    override fun getCount(): Int {
        return mSlides!!.size

    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0==p1  //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var p0:View=layoutInflater!!.inflate(mSlides!!.get(position),container,false)
        container.addView(p0)
        return p0
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
           var view:View  = `object` as View
        container.removeView(view)


    }

}
        */