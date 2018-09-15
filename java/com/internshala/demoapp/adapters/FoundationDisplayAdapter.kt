package com.internshala.demoapp.adapters

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.facebook.share.widget.MessageDialog
import com.internshala.demoapp.R
import com.internshala.demoapp.about.AchievmentList
import com.squareup.picasso.Picasso

class FoundationDisplayAdapter(mContext:Context)
    : RecyclerView.Adapter<FoundationDisplayAdapter.NavViewHolder>() {
   var  _context:Context?=null
    var achievmentListvar:AchievmentList?=null
    var years = arrayListOf<String>("2017","2016","2015","2014","2013","2012","2011","2010","2009","2007","2004")
    var achievmentListFirst= arrayListOf<String>("Honorary Doctorate from North Ossetian State University, Vladikavkaz, Russia",
            "Czech Varsity Confers Honorary Doctorate",
            "‘BEST WORKER’ Highest Civilian Award of Republic of Mongolia",
            "Dr. Pinnamaneni and Seethadevi Foundation Award",
            "Lifetime Achievement in Education Leadership 2013 Presented by Education World",
            "15th Bhagwan Mahaveer Award",
            "Dainik Bhaskar India Pride Award 2011 for being a Change Agent",
            "National Young EDGE Award – Emerging Direction in Global ",
            "Gandhi Seva Medal by Gandhi Global Family in recognition of Philanthropic and Charitable works for the downtrodden",
            "Priya Odiya Samman 2007 (Most Endeared Personality in Odisha) through a survey by a National TV Channel",
            "Humanitarian Award from Mahatma Gandhi Remembrance Organization, Johannesburg, South Africa")
    var achievmentListSecond= arrayListOf<String>("Honorary Doctorate from from Dibrugarh University, Assam",
            "Pride of India award",
            "‘Isa Award for Service to Humanity’, the highest civilian award of Bahrain",
            "CSI Fellowship Award at Hyderabad",
            "Kumara Shri 2013 Samman – Presented by YOUTH a socio-cultural organisation for exemplary work in the field of Education & Social Service.",
            "Honorary Doctorate for Dr. Samanta by National Formosa University, Taiwan",
            "D.Litt. Degree (Honoris Causa) from Rashtriya Sanskrit Vidyapeetha (Central University), Tirupati (A.P.)\n",
            "Asia’s Best Social Entrepreneur Award by the World HRD Congress conferred on 23rd July, 2010, Singapore",
            "Degree of Honorary Doctorate (Honoris Causa) from National University of Cambodia",
            "Placed within 15 best Social Entrepreneur of the world by Social Edge, an offshoot of skoll Foundation",
            "Honorary Ph.D (2002) and D.Sc (2005) from OIU, Colombo"
    )
    init {
        this._context=mContext
    Log.d("Foundation","hellow there")
    }
    override fun onBindViewHolder(p0: NavViewHolder, p1: Int) {

        try {
            p0.year?.setText(years.get(p1))

            p0.textOne?.setText(achievmentListFirst.get(p1))
            p0.texttwo?.setText(achievmentListSecond.get(p1))
            if (p1==0 || p1==10) {
                p0.readMore?.visibility = View.INVISIBLE
            }
            else
            {
                p0.readMore?.visibility = View.VISIBLE
            }
            p0.readMore?.setOnClickListener({

              /*  var  alertDialog= AlertDialog.Builder(_context).create()
                (alertDialog as AlertDialog)?.setMessage()

                alertDialog.setButton("OK") { dialog, which ->
                    // Write your code here to execute after dialog closed

                }
                alertDialog.show()  */
                if (p1==1)
                {
                    alertMessageTwo()
                }
                else if (p1==2)
                {
                    alertMessageThree()
                }
                else if (p1==3)
                {
                    alertMessageFour()
                }
                else if (p1==4)
                {

                    alertMessageFive()
                }
                else if (p1==5)
                {

                    alertMessageSix()
                }
                else if (p1==6)
                {

                    alertMessageSeaven()
                }
                else if (p1==7)
                {
                    alertMessageEight()
                }
                else if (p1==8)
                        {
                         alertMessageNine()
                        }

                else
                {
                    alertMessageTen()
                }




            })

        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }


    }

    override fun getItemCount(): Int {
        if(years.size==null)
        {
            Log.d("Achievment",""+years)
            return 0
        }
        else
        { // Log.d("Achievment",""+years.size)
            return (years as ArrayList).size
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NavViewHolder {

        var itemView = LayoutInflater.from(p0?.context)
                .inflate(R.layout.row_custome_achievments, p0, false)
        var returnThis = FoundationDisplayAdapter.NavViewHolder(itemView)
        return returnThis

    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView as View) {

 var bubbleOne:ImageView?=null
        var bubbletwo:ImageView?=null
        var textOne:TextView?=null
        var texttwo:TextView?=null
        var year:TextView?=null
        var readMore:CardView?=null
        init {
            bubbleOne= itemView?.findViewById(R.id.bubbleone)
            bubbletwo=itemView?.findViewById(R.id.bubbletwo)
            textOne=itemView?.findViewById(R.id.firstAchievment)
            texttwo=itemView?.findViewById(R.id.SecondAchievment)
            year=itemView?.findViewById(R.id.years)
            readMore=itemView?.findViewById(R.id.knowMoreClickableAchiev)
        }

    }

    fun alertMessageTwo(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2016 \n\n" +
                "Czech Varsity Confers Honorary    Doctorate \n\n" +
                "Pride of India award\n\n" +
                "NIQR Bajaj Outstanding Quality Man    Award" )

        alertDialog.setButton("Go Back") { dialog, which ->
              // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageThree(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2015 \n\n" +
                "‘BEST WORKER’ Highest Civilian Award of Republic of Mongolia\"\n\n" +
                "‘Isa Award for Service to Humanity’ the highest civilian award of Bahrain\"\n\n" +
                "True Legend Award\",\n\n" +
                "Hall of Fame Award presented by World CSR Congress\",\n\n" +
                "Successful Entrepreneur Award at Economic Times Entrepreneurship Summit\",\n\n" +
                "‘Civilian Award’ Czech Republic" )

        alertDialog.setButton("Go Back") { dialog, which ->

            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageFour(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2014 \n\n" +
                "Dr. Pinnamaneni and Seethadevi Foundation Award \n\n" +
                "CSI Fellowship Award at Hyderabad \n\n" +
                "President’s Gold Medal 2014 from International Association of Knowledge, Znanie, Moscow\n\n" +
                "GUSI Peace Prize International 2014 at Manila, Philippines \n\n" +
                "Honorary Doctorate of Letters (D.Litt) from Chosun University, South Korea \n\n" +
                "Honorary Ph.D from Roshdiyeh Higher Education, Tabriz, Iran \n\n" +
                "‘2013 World of Difference Awards’ by US-based International Alliance for Women (TIAW) \n\n" +
                "Honorary Doctorate of Letters (D.Litt) from International University of Kyrgyzstan\n\n" +
                "Honorary Doctorate of Letters (D.Litt) from Daffodil International University, Dhaka, Bangladesh" )

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageFive(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2013 \n\n" +
                "Lifetime Achievement in Education Leadership 2013 Presented by Education World \n\n" +
                "Kumara Shri 2013 Samman – Presented by YOUTH a socio-cultural organisation for exemplary work in the field of Education & Social Service.\n\n"+
                "The Highest Prize of Czech University of Life Sciences (CULS) – A Sculpture of Honour of the Goddess of Harvest OPS – in Prague, Czech Republic  \n\n" +
                "Utkalshree Award 2012")

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageSix(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2012 \n\n" +
                "15th Bhagwan Mahaveer Award \n\n" +
                "Honorary Doctorate for Dr. Samanta by National Formosa University, Taiwan \n\n" +
                "Qimpro Platinum Standard 2011 Award for Education\n\n" +
                "Jawaharlal Nehru Award \n\n" )

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageEight(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2010 \n\n" +
                "National Young EDGE Award – Emerging Direction in Global Education (EDGE) for outstanding contribution in Education \n\n" +
                "Asia’s Best Social Entrepreneur Award by the World HRD Congress conferred on 23rd July, 2010, Singapore \n\n" +
                "Swami Vivekananda National Award by the Department of Youth Services and Sports, Govt. of Karnataka \n\n" +
                "Degree of Honorary Doctorate (Honoris Causa) from Hanseo University, South Korea"  )

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageSeaven(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2011 \n\n" +
                "Dainik Bhaskar India Pride Award 2011 for being a Change Agent in the field of Social Development and Equity \n\n" +
                "D.Litt. Degree (Honoris Causa) from Rashtriya Sanskrit Vidyapeetha (Central University), Tirupati (A.P.) \n\n" +
                "Godfrey Phillips Bravery Award (Social Bravery Award) in recognition of an exceptional Act of Courage \n\n" +
                "ICON of Odisha – 2011 by Times of India \n\n" +
                "Rajdhani Gaurav Samman\n\n" +
                "Gurudev Rabindranath Tagore Samman – in recognition of outstanding services, achievements and contributions.\n\n" +
                "Ruchi Odisha Gaurav Samman’")

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageNine(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2009 \n\n" +
                "Gandhi Seva Medal by Gandhi Global Family in recognition of Philanthropic and Charitable works for the downtrodden \n\n" +
                "Degree of Honorary Doctorate (Honoris Causa) from National University of Cambodia \n\n" +
                "Nominated for International WISE Awards, Qatar Foundation, Doha" )

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }
    fun alertMessageTen(){

        var  alertDialog= AlertDialog.Builder(_context).create()
        (alertDialog as AlertDialog)?.setMessage("                        2007 \n\n" +
                "Priya Odiya Samman 2007 (Most Endeared Personality in Odisha) through a survey by a National TV Channel \n\n" +
                "Placed within 15 best Social Entrepreneur of the world by Social Edge, an offshoot of skoll Foundation \n\n" +
                "Youngest Chancellor of any University in India ( Limca Book of Records-2007)" )

        alertDialog.setButton("Go Back") { dialog, which ->
            // Write your code here to execute after dialog closed

        }
        alertDialog.show()
    }

}
/*  var title:String="SOCIAL ENTERPRENURSHIP"
    var subtitle:String="Started with seed money of Rs. 5000/- ($100)"
     var myears= arrayListOf<String>("1992","1997","2002","2005","2007","2008","2010","2012","2013","2014","2015"
    ,"2016","2017") */