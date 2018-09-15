package com.internshala.demoapp

import android.os.Bundle
import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

import kotlinx.android.synthetic.main.activity_screen_slide_page.*
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


@Suppress("CAST_NEVER_SUCCEEDS")
class ScreenSlidePage : AppCompatActivity() {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
   //  val NUM_PAGES = 2

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.

     var mPager: ViewPager? = null

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
     var mPagerAdapter: PagerAdapter? = null
    var mSlides= arrayListOf<Int>(R.layout.activity_facebook_page,R.layout.activity_twitterpage
            ,R.layout.activity_news)   */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide_page)

        // Instantiate a ViewPager and a PagerAdapter.

     //  Toast.makeText(this,""+mSlides.size,Toast.LENGTH_LONG).show()

     /**    mPager =  findViewById(R.id.pager)
 *       mPagerAdapter = ScreenSlidePagerAdapter(this,supportFragmentManager)
  *      mPager?.setAdapter(mPagerAdapter)

*/





    }

 /*   override fun onBackPressed() {
        if (mPager?.getCurrentItem() === 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            mPager?.setCurrentItem(mPager?.getCurrentItem()!!.minus(1) )
        }
    }
    */

}


