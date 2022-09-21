package com.rave.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

interface MyInterFace {
    fun doStuff()
}


class MainActivity : AppCompatActivity(), MyInterFace {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.btn_start_button)

        startButton.setOnClickListener {
            Log.d(TAG, "onCreate: start button is working ")
            val calculatorIntent = Intent(applicationContext, CalculatorActivity::class.java)
            startActivity(calculatorIntent)
        }


    }
    companion object{
        const val TAG="MainActivityLog"
    }

    override fun doStuff() {
        TODO("Not yet implemented")
    }
}