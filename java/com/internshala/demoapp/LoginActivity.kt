package com.internshala.demoapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager

import android.app.Activity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast
import com.internshala.demoapp.ApiClient.*

import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : Activity(), LoaderCallbacks<Cursor> {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    var url: URL?=null
    var mcontext: Context?=null
    var alertDialog: AlertDialog?=null
    var line:String?=null
    var connectivityManager: ConnectivityManager? = null
    var networkInfo: NetworkInfo? = null
    private var mAuthTask: UserLoginTask? = null
     var backGroundWorker:BackGroundWorker?=null
//api variable declartion
object Statified {
    var mID= arrayListOf<String>()
    var mTitle= arrayListOf<String>()
    var mCOntent= arrayListOf<String>()
    var mEXcerpt= arrayListOf<String>()
  //  var mMediaAttachment= arrayListOf<String>()
    var mIDBlog= arrayListOf<String>()
    var mTitleBlog= arrayListOf<String>()
    var mCOntentBlog= arrayListOf<String>()
    var mEXcerptBlog= arrayListOf<String>()
    var mfalseLoop:Int =0
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.
        populateAutoComplete()
        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener {
        if (checkInternetConnectivity() as Boolean) {
            attemptLogin()
        }
        else
        {
            Toast.makeText(this, "OOps check for the Internet Connection", Toast.LENGTH_SHORT).show()
        }
    }


        email_sign_up_button.setOnClickListener({

if (checkInternetConnectivity()as Boolean )
{
  var i = Intent(this@LoginActivity,RegistrationActivity::class.java)
            startActivity(i)
          //  this.finish()
        }
            else
{
    Toast.makeText(this, "OOps check for the Internet Connection", Toast.LENGTH_SHORT).show()
}
    })

    }

    private fun populateAutoComplete() {
        if (!mayRequestContacts()) {
            return
        }

        loaderManager.initLoader(0, null, this)
    }

    private fun mayRequestContacts(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            // TODO: alert the user with a Snackbar/AlertDialog giving them the permission rationale
            // To use the Snackbar from the design support library, ensure that the activity extends
            // AppCompatActivity and uses the Theme.AppCompat theme.
        } else {
            requestPermissions(arrayOf(READ_CONTACTS), REQUEST_READ_CONTACTS)
        }
        return false
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete()
            }
        }
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private fun attemptLogin() {
        if (mAuthTask != null) {
            return
        }

        // Reset errors.
        email.error = null
        password.error = null

        // Store values at the time of the login attempt.
        val emailStr = email.text.toString()
        val passwordStr = password.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(passwordStr)&& !isPasswordValid(passwordStr))
         {
            password.error = getString(R.string.error_invalid_password)
            focusView = password
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            email.error = getString(R.string.error_field_required)
            focusView = email
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            email.error = getString(R.string.error_invalid_email)
            focusView = email
            cancel = true
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true)
            var type:String="Login"
           // backGroundWorker= BackGroundWorker(this)
          //  backGroundWorker?.execute(type,emailStr , passwordStr)
             mAuthTask = UserLoginTask(emailStr, passwordStr)
            mAuthTask!!.execute(null as Void?)

        }
    }

    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 4
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            login_form.visibility = if (show) View.GONE else View.VISIBLE
            login_form.animate()
                    .setDuration(shortAnimTime)
                    .alpha((if (show) 0 else 1).toFloat())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            login_form.visibility = if (show) View.GONE else View.VISIBLE
                        }
                    })

            login_progress.visibility = if (show) View.VISIBLE else View.GONE
            login_progress.animate()
                    .setDuration(shortAnimTime)
                    .alpha((if (show) 1 else 0).toFloat())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            login_progress.visibility = if (show) View.VISIBLE else View.GONE
                        }
                    })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            login_progress.visibility = if (show) View.VISIBLE else View.GONE
            login_form.visibility = if (show) View.GONE else View.VISIBLE
        }
    }

    override fun onCreateLoader(i: Int, bundle: Bundle?): Loader<Cursor> {
        return CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE + " = ?", arrayOf(ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE),

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC")
    }

    override fun onLoadFinished(cursorLoader: Loader<Cursor>, cursor: Cursor) {
        val emails = ArrayList<String>()
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS))
            cursor.moveToNext()
        }

        addEmailsToAutoComplete(emails)
    }

    override fun onLoaderReset(cursorLoader: Loader<Cursor>) {

    }

    private fun addEmailsToAutoComplete(emailAddressCollection: List<String>) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        val adapter = ArrayAdapter(this@LoginActivity,
                android.R.layout.simple_dropdown_item_1line, emailAddressCollection)

        email.setAdapter(adapter)
    }

    object ProfileQuery {
        val PROJECTION = arrayOf(
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY)
        val ADDRESS = 0
        val IS_PRIMARY = 1
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */

    inner class UserLoginTask internal constructor(private val mEmail: String, private val mPassword: String) : AsyncTask<Void, Void, Boolean>() {


        var mEmailStr:String?=null
        var mPasswordStr:String?=null
        init {
            this.mEmailStr=mEmail
            this.mPasswordStr=mPassword
        }
        override fun doInBackground(vararg params: Void): Boolean? {
            var loginStr="http://10.0.141.135/Kiit/Login.php"

                try {
                    // mEmailStr=params[0] as String
                    // mPasswordStr=params[1] as String
                    url=URL(loginStr)
                    var  httpUrlConnection: HttpURLConnection =url?.openConnection() as HttpURLConnection
                    httpUrlConnection?.requestMethod="POST"
                    httpUrlConnection?.doOutput(true)
                    httpUrlConnection?.doInput(true)
                    var outputStream: OutputStream =httpUrlConnection.outputStream
                    var bufferedWriter: BufferedWriter = BufferedWriter(OutputStreamWriter(outputStream,"UTF-8"))
                    var mPostData:String= URLEncoder.encode("mEmailStr","UTF-8")+"="+ URLEncoder.encode(mEmailStr,"UTF-8")+"&"+ URLEncoder.encode("mPasswordStr","UTF-8")+"="+ URLEncoder.encode(mPasswordStr,"UTF-8")
                    bufferedWriter.write(mPostData)
                    bufferedWriter.flush()
                    bufferedWriter.close()
                    outputStream.close()
                }
                catch (e: MalformedURLException)
                {
                    e.printStackTrace()
                }
                catch (e: IOException){
                    e.printStackTrace()
                }// TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                return false
            }

            return DUMMY_CREDENTIALS
                    .map { it.split(":") }
                    .firstOrNull { it[0] == mEmail }
                    ?.let {
                        // Account exists, return true if the password matches.
                        it[1] == mPassword
                    }
                    ?: true
        }

        override fun onPostExecute(success: Boolean?) {
            mAuthTask = null
            showProgress(false)

            if (success!!) {
                finish()
            } else {
                password.error = getString(R.string.error_incorrect_password)
                password.requestFocus()
            }
        }

        override fun onCancelled() {
            mAuthTask = null
            showProgress(false)
        }

    }

    companion object {

        /**
         * Id to identity READ_CONTACTS permission request.
         */
        private val REQUEST_READ_CONTACTS = 0

        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */
        private val DUMMY_CREDENTIALS = arrayOf("foo@example.com:hello", "bar@example.com:world")
    }
    fun checkInternetConnectivity():Boolean
    {
        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        networkInfo =connectivityManager?.activeNetworkInfo
        return networkInfo !=null && networkInfo!!.isConnected ()
    }


fun guestLogin(view: View)
    {
        if (checkInternetConnectivity() as Boolean) {


            ApiCAlling()

            var i:Intent= Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(i)
            finish()
        }
        else
        {
            Toast.makeText(this, "OOps check for the Internet Connection", Toast.LENGTH_SHORT).show()
        }

    }

    fun ApiCAlling()
    {
        var apiInterface = ApiClient.Staticated.getClient().create(APIInterface::class.java)
        var call: Call<ArrayList<Awards>> = apiInterface.doGetUserList()

        // changes are made her eto check the

        //   Toasta.makeText(getApplicationContext(),"Value is" +AboutActivity.Statified.mId,Toast.LENGTH_LONG ).show()

        call.enqueue(object : Callback<ArrayList<Awards>> {
            override fun onResponse(call: Call<ArrayList<Awards>>?, response: Response<ArrayList<Awards>>?) {
                //  Toast.makeText(this@AboutActivity,"hellow u are here ",Toast.LENGTH_LONG).show()
                Log.d("AsynkTask", "Server Response: " + response.toString())
                Log.d("AsynkTask", "ServerBody" + response?.body().toString())

                for (i in 0 until response?.body()!!.size) {

                    var jsonObject = response?.body()!!.get(i)
                    var arrayList = ArrayList<Awards>()

                    // AboutActivity.Statified.mId.add(mid as String)

                    //id
                   var mid =jsonObject.id

                    Statified.mID.add(mid!!)


                    // tiitle
                    var mRendered = jsonObject.title?.rendered

                    //title class value setter
                    var mtitle = Title(mRendered as String)
                    Statified.mTitle.add(mRendered)

                    //Ecerpt

                    var renderedExcerpt = jsonObject.excerpt?.rendered

                    // Excerpt class value setter
                    var mExcerpt = Excerpt(renderedExcerpt)
                    Statified.mEXcerpt.add(renderedExcerpt!!)

                    //Content
                    var mRenderedContent = jsonObject.content?.rendered

                    // Content class setter
                    var mContent = Content(mRenderedContent as String)
                    Statified.mCOntent.add(mRenderedContent)





                }
                /*      mAwardAdapterr = AwardAdapter(mID,mTitle,mEXcerpt,mCOntent,this@AboutActivity)

      */


            }

            override fun onFailure(call: Call<ArrayList<Awards>>?, t: Throwable?) {
                Log.e("AsynkTask", "Something went wrong error " + t?.printStackTrace())
                // Toast.makeText(this@AboutActivity,"Something wrong here ", Toast.LENGTH_LONG).show()


            }
        })


    }

}


