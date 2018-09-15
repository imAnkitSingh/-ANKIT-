package com.internshala.demoapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
//import android.support.v4.view.GravityCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.internshala.demoapp.ApiClient.APIInterface
import com.internshala.demoapp.ApiClient.ApiClient
//import com.internshala.demoapp.ApiClient.UserList
import kotlinx.android.synthetic.main.app_bar_main.*
import com.internshala.demoapp.adapters.NavigationDrawerAdapter
import com.internshala.demoapp.adapters.ScreenSlidePagerAdapter
import com.internshala.demoapp.adapters.onMenuClickListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), onMenuClickListener {
   //   will remove in future if not required    NavigationView.OnNavigationItemSelectedListener
    override fun onImageClick(position: Int) {


       if (position==0) {
            Handler().postDelayed({
            var i: Intent = Intent(baseContext, AboutActivity::class.java)
            startActivity(i)},0)
            overridePendingTransition(0, 0)
        }
       else if (position==1)
        {
            var i:Intent = Intent(baseContext, Contact::class.java)
                startActivity(i)
            overridePendingTransition(0, 0)
        }
       else
        {  Handler().postDelayed(
                {
                    var i:Intent = Intent(baseContext, Notifications::class.java)
                    startActivity(i)
                    overridePendingTransition(0, 0)},0)



        }
    }
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    var mPager: ViewPager? = null

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    var mPagerAdapter: PagerAdapter? = null
// Navigation drawer variable

    var mnav_view:NavigationView?=null
    var drawerLayout:DrawerLayout?=null
     var navigationDrawer_iconList = arrayListOf<String>()
    var imageFor_navigationDrawer = intArrayOf(R.drawable.aboutt, R.drawable.about
            , R.drawable.notification)  //for now this portionn is under construction so keep in mind
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        drawerLayout=findViewById(R.id.drawer_layout)
        navigationDrawer_iconList.add("About")
        navigationDrawer_iconList.add("Contact")
        navigationDrawer_iconList.add("Testimonials")
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
     //   mnav_view= findViewById(R.id.nav_view)
        val _navigationDrawerAdapter = NavigationDrawerAdapter(navigationDrawer_iconList,
                imageFor_navigationDrawer, this, this)
        var navigation_recycler_view = findViewById<RecyclerView>(R.id.navigation_recycler_view)
        navigation_recycler_view.layoutManager = LinearLayoutManager(this)
        navigation_recycler_view.itemAnimator = DefaultItemAnimator()
        navigation_recycler_view.adapter = _navigationDrawerAdapter
        navigation_recycler_view.setHasFixedSize(true)





      //will be removed in future       mnav_view?.setNavigationItemSelectedListener(this)


// calling pageView adapters
        mPager =  findViewById(R.id.pager)
        mPager?.setClipToPadding(false);
      //  mPager?.setPageMargin(50)
        mPagerAdapter = ScreenSlidePagerAdapter(this, supportFragmentManager)
        mPager?.setAdapter(mPagerAdapter)

        // checking retrofit
     /*   var   retrofit = Retrofit.Builder()
                .baseUrl("https://achyutasamanta.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                */







    }

  /*  override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }



    }  */

  /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }   */


  /*  override fun onNavigationItemSelected(item: MenuItem):Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {

            R.id.nav_About -> {

                Toast.makeText(this,"hellow",Toast.LENGTH_LONG).show()



                    var i: Intent = Intent(baseContext, AboutActivity::class.java)
                    startActivity(i)
                    overridePendingTransition(0, 0)





                    // Handle the camera action

            }




            R.id.nav_Contact -> {
             var mContact:Intent= Intent(this@MainActivity,Contact::class.java)
                this.startActivity(mContact)
            }
            R.id.nav_Notifications -> {
                var mNotification=Intent(this@MainActivity,Notifications::class.java)
                this.startActivity(mNotification)
            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
            else ->{
                Toast.makeText(this,"hellow Blank",Toast.LENGTH_LONG).show()
            }

        }



      //  drawer_layout.closeDrawer(GravityCompat.START)
        return true

    }
     fun onclick()
    {
        Handler().postDelayed({
            var i: Intent = Intent(baseContext, AboutActivity::class.java)
            startActivity(i)},0)


    }  */
}

