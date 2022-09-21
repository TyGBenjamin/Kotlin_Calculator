package com.rave.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        btn_clear.setOnClickListener{
            Log.d(TAG, "onCreate: Clear button clicked")
            input_display.text = " "
            output_display.text = " "
        }

//        Much easier way to do this is to access the children of the TableLayout or Table Rows
//        Will improve code as learn how to interact wiht kotlin more

        btn_leftParenthesis.setOnClickListener{
            input_display.text = addInput("(")
        }

        btn_rightParenthesis.setOnClickListener{
            input_display.text = addInput(")")
        }

        btn_0.setOnClickListener{
            input_display.text = addInput("0")
        }

        btn_1.setOnClickListener{
            input_display.text = addInput("1")
        }

        btn_2.setOnClickListener{
            input_display.text = addInput("2")
        }

        btn_3.setOnClickListener{
            input_display.text = addInput("3")
        }

        btn_4.setOnClickListener{
            input_display.text = addInput("4")
        }

        btn_5.setOnClickListener{
            input_display.text = addInput("5")
        }

        btn_6.setOnClickListener{
            input_display.text = addInput("6")
        }

        btn_7.setOnClickListener{
            input_display.text = addInput("7")
        }

        btn_8.setOnClickListener{
            input_display.text = addInput("8")
        }

        btn_9.setOnClickListener{
            input_display.text = addInput("9")
        }

        btn_multiply.setOnClickListener{
            input_display.text = addInput("*")
        }

        btn_divide.setOnClickListener{
            input_display.text = addInput("/")
        }
        btn_equals.setOnClickListener{
            input_display.text = addInput("=")
        }

        btn_plus.setOnClickListener{
            input_display.text = addInput("+")
        }

        btn_minus.setOnClickListener{
            input_display.text = addInput("-")
        }
    }
    private fun addInput(buttonValue:String): String{
        return "${input_display.text}$buttonValue"
    }

    companion object{
        const val TAG="CalculatorActivityLog"
    }
}