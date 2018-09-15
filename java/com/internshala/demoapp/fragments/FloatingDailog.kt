package com.internshala.demoapp.fragments


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.internshala.demoapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FloatingDailog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floating_dailog, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        return super.onCreateDialog(savedInstanceState)

                // set Dialog Title
              //  .setTitle("Alert dialog fragment example")
                // Set Dialog Message
              //  .setMessage("This is a message")

                // positive button
             //   .setButton("OK",  DialogInterface.BUTTON_POSITIVE)




                // negative button
             /*   .setButton("Cancel", DialogInterface.OnClickListener() {
                    fun onClick( dialog:DialogInterface, which: Int) {
                        Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                }).create();   */




    }


}
