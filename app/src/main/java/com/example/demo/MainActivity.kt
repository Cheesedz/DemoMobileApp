package com.example.demo;

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.demo.AirPlaneModeChange

class MainActivity : ComponentActivity() {
    //Intent demo
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // send button on click listener
//        val sendButton = findViewById<Button>(R.id.sendButton)
//        sendButton.setOnClickListener {
//            var intent = Intent(Intent.ACTION_SEND) // intent
//            intent.type = "text/plain"
//            startActivity(intent)
//        }
//
//        // View on click listener
//        val buttonView = findViewById<Button>(R.id.buttonView)
//        buttonView.setOnClickListener {
//            var intent = Intent(Intent.ACTION_VIEW)
//            startActivity(intent)
//        }
//    }

    /*--------------------------------------------------------------------*/
    //
    // register the receiver in the main activity in order to receive updates of broadcasts events if they occur
    lateinit var receiver: AirPlaneModeChange
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonView = findViewById<Button>(R.id.buttonView)
        val textView = findViewById<TextView>(R.id.textView)

        // Set up the AirPlaneModeChangeReceiver
        receiver = AirPlaneModeChange()
        receiver.setTextViewForAirplaneMode(textView)

        // Intent Filter is useful to determine which apps wants to receive
        // which intents,since here we want to respond to change of
        // airplane mode
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(receiver, it)
        }
    }

    // since AirplaneModeChangeReceiver class holds a instance of Context
    // and that context is actually the activity context in which
    // the receiver has been created
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
