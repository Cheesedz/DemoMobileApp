package com.example.demo;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // send button on click listener
        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND) // intent
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "niranjantest@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a dummy message")
            intent.putExtra(Intent.EXTRA_TEXT, "Dummy test message")
            startActivity(intent)
        }

        // View on click listener
        val buttonView = findViewById<Button>(R.id.buttonView)
        buttonView.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }
    }
}
