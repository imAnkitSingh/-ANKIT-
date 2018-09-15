package com.internshala.demoapp

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class BackGroundWorker (context:Context) : AsyncTask<String,Void,String>()
{   var url:URL?=null
    var mcontext: Context?=null
    var alertDialog:AlertDialog?=null
    var line:String?=null

    init {
        this.mcontext=context
    }
    override fun doInBackground(vararg p0: String?): String? {
       var type:String=p0[0] as String
        var RegisterStr:String="http://10.0.141.135/Kiit/Signup.php"
        if (type.equals("Register"))
        {
            try {
                var mNameStr:String=p0[1] as String
                var mEmailStr:String=p0[2] as String
                var mPassWordStr:String=p0[3] as String
                var mConfirmPasswordStr:String=p0[4] as String
                var mCity:String=p0[5] as String
                url=URL(RegisterStr)
               var  httpUrlConnection:HttpURLConnection=url?.openConnection() as HttpURLConnection
                httpUrlConnection?.requestMethod="POST"
                httpUrlConnection?.doOutput=true
                httpUrlConnection?.doInput=true
                var outputStream:OutputStream =httpUrlConnection.outputStream
                var bufferedWriter:BufferedWriter= BufferedWriter(OutputStreamWriter(outputStream,"UTF-8"))
                var mPostData:String=URLEncoder.encode("mNameStr","UTF-8")+"="+URLEncoder.encode(mNameStr,"UTF-8")+"&"+URLEncoder.encode("mEmailStr","UTF-8")+"="+URLEncoder.encode(mEmailStr,"UTF-8")+"&"+ URLEncoder.encode("mPassWordStr","UTF-8")+"="+URLEncoder.encode(mPassWordStr,"UTF-8")+"&"+URLEncoder.encode("mConfirmPasswordStr","UTF-8")+"="+URLEncoder.encode(mConfirmPasswordStr,"UTF-8")+"&"+URLEncoder.encode("mCity","UTF-8")+"="+URLEncoder.encode(mCity,"UTF-8")
                bufferedWriter.write(mPostData)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
              var inputStram:InputStream=httpUrlConnection.inputStream
                var bufferedReader:BufferedReader= BufferedReader(InputStreamReader(inputStram,"iso-8859-1"))
                var mResult:String?=null
                while((bufferedReader.readLine())!=null) {
                    line = bufferedReader.readLine()
                    mResult += line
                }
                bufferedReader.close()
                inputStram?.close()
                httpUrlConnection.disconnect()
                return mResult as String
            }
            catch (e: MalformedURLException)
            {
                e.printStackTrace()
            }
            catch (e: IOException){
                e.printStackTrace()
            }

        }
        return null

    }



// this  method is to set the dialogBox
    override fun onPreExecute() {
       // super.onPreExecute()
        alertDialog=AlertDialog.Builder(mcontext).create()
        // this is to genreate a box type Structure
        // the we comtain the message from php in case of web page it is directly get displayed on
        // web Pages
    (alertDialog as AlertDialog)?.setTitle("Signup Status")


    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        alertDialog?.setMessage(result)
        alertDialog?.show() // this step let the message displayed that our php is sending
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }
}

fun HttpURLConnection.doInput(b: Boolean) {

}

internal fun HttpURLConnection.doOutput(any: Boolean) {

}

internal operator fun String.invoke(s: String) {

}
