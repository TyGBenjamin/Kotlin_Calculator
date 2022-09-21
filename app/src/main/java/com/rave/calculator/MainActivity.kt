package com.rave.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val letGetStartedButton = findViewById<Button>(R.id.btn_lets_get_started)

        val calculatorIntent = Intent(applicationContext, CalculatorActivity::class.java)

        letGetStartedButton.setOnClickListener {
            Log.d(TAG, "onCreate: let's get started button clicked")
            startActivity(calculatorIntent)
        }
    }

    companion object {
        const val TAG = "MainActivityLogger"
    }
}