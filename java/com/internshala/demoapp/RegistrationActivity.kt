package com.internshala.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class RegistrationActivity : AppCompatActivity() {
   var mName: AutoCompleteTextView?=null
    var mEmail:AutoCompleteTextView?=null
    var mPassword: EditText?=null
    var mConfirmPassword:EditText?=null
    var mCity:AutoCompleteTextView?=null
    var backGroundWorker:BackGroundWorker?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        mName=findViewById(R.id.mName)
        mEmail=findViewById(R.id.mEmail)
        mPassword=findViewById(R.id.mPassword)
        mConfirmPassword=findViewById(R.id.mConfirmpassord)
        mCity=findViewById(R.id.mCity)
    }

    fun saveToMyDataBase(view:View)
    {

        var EmailStr:String = mEmail?.text.toString()
        var PasswordStr:String = mPassword?.text.toString()
        var NameStr:String = mName?.text.toString()
        var ConfirmPasswordStr:String = mConfirmPassword?.text.toString()
        var City:String = mCity?.text.toString()
        var type:String="Register"
      backGroundWorker = BackGroundWorker(this)
        backGroundWorker?.execute(type,NameStr,EmailStr,PasswordStr,ConfirmPasswordStr,City)



    }
}