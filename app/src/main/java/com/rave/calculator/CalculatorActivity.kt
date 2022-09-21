package com.rave.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.rave.calculator.CalculatorActivity.Companion.TAG
//import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

var inputDisplay: TextView = findViewById<TextView>(R.id.calc_activity_text)
var outputDisplay: TextView = findViewById<TextView>(R.id.result_text)
private var canAdd = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val leftParenButton = findViewById<Button>(R.id.btn_leftParenthesis)
        val rightParenButton = findViewById<Button>(R.id.btn_rightParenthesis)
        val equalsButton= findViewById<Button>(R.id.btn_equals)
        val clearButton = findViewById<Button>(R.id.btn_clear)
        



        clearButton.setOnClickListener{
            Log.d(TAG, "onCreate: clear button clicked")
            inputDisplay.text = " "
            outputDisplay.text = ""

        }

    }

//    fun numberInput(view: View){
//        if(view is Button){
//            inputDisplay.append(view.text)
//            canAdd= true
//        }
//    }
//    fun operationInput(view:View){
//        if(view is Button && canAdd){
//           inputDisplay.append(view.text)
//            canAdd = false
//        }
//    }

//    fun clearAll(view: View){
//        inputDisplay.text = ""
//    }
//    fun equalsInput(view: View){}

    companion object{
        const val TAG="CalcActivityLog"
    }
}

