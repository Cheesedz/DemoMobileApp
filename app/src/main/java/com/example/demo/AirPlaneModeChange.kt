package com.example.demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

// AirplaneModeChangeReceiver class extending BroadcastReceiver class
class AirPlaneModeChange : BroadcastReceiver() {
    var textView: TextView? = null

    // Function to set the TextView instance
    fun setTextViewForAirplaneMode(tv: TextView?) {
        textView = tv
    }

    // this function will be executed when the user changes his airplane mode
    override fun onReceive(context: Context?, intent: Intent?) {

        // intent contains the information about the broadcast in our case broadcast is change of airplane mode
        // TextView instance to update its content

        // if getBooleanExtra contains null value,it will directly return back
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        // checking whether airplane mode is enabled or not
        if (isAirplaneModeEnabled) {
            // showing the toast message if airplane mode is enabled
            //Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
            textView?.text = "Airplane Mode Enabled"
        } else {
            // showing the toast message if airplane mode is disabled
            //Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
            textView?.text = "Airplane Mode Disabled"
        }
    }
}
