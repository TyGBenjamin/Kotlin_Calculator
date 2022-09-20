package com.rave.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val helloWorldTextView = findViewById<TextView>(R.id.tv_hello_world)
        helloWorldTextView.text = "Goodbye, world!"

        val changeStuffButton = findViewById<Button>(R.id.btn_change_stuff)
        val colorView = findViewById<View>(R.id.v_color)

        changeStuffButton.setOnClickListener {
            helloWorldTextView.text = "Something different"
        }

        colorView.setOnClickListener {
            colorView.setBackgroundColor(resources.getColor(R.color.purple_500))
        }
    }
}