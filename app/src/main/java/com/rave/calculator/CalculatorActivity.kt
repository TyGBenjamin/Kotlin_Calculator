package com.rave.calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)



        btn_clear.setOnClickListener {
            Log.d(TAG, "onCreate: Clear button clicked")
            input_display.text = " "
            output_display.text = " "
        }

        fun addInput(buttonValue: String): String {
            return "${input_display.text}$buttonValue"
        }


//        Much easier way to do this is to access the children of the TableLayout or Table Rows
//        Will improve code as learn how to interact wiht kotlin more

        btn_leftParenthesis.setOnClickListener {
            input_display.text = addInput("(")
            output_display.text = ""
        }

        btn_rightParenthesis.setOnClickListener {
            input_display.text = addInput(")")
        }

        btn_0.setOnClickListener {
            input_display.text = addInput("0")
            output_display.text = ""
            numberAdded(0f)
        }

        btn_1.setOnClickListener {
            input_display.text = addInput("1")
            output_display.text = ""
            numberAdded(1f)
        }

        btn_2.setOnClickListener {
            input_display.text = addInput("2")
            output_display.text = ""
            numberAdded(2f)
        }

        btn_3.setOnClickListener {
            input_display.text = addInput("3")
            output_display.text = ""
            numberAdded(3f)
        }

        btn_4.setOnClickListener {
            input_display.text = addInput("4")
            output_display.text = ""
            numberAdded(4f)
        }

        btn_5.setOnClickListener {
            input_display.text = addInput("5")
            output_display.text = ""
            numberAdded(5f)
        }

        btn_6.setOnClickListener {
            input_display.text = addInput("6")
            output_display.text = ""
            numberAdded(6f)
        }

        btn_7.setOnClickListener {
            input_display.text = addInput("7")
            output_display.text = ""
        }

        btn_8.setOnClickListener {
            input_display.text = addInput("8")
            output_display.text = ""
            numberAdded(8f)
        }

        btn_9.setOnClickListener {
            input_display.text = addInput("9")
            output_display.text = ""
            numberAdded(9f)
        }

        btn_multiply.setOnClickListener {
            input_display.text = addInput("*")
            operatorAdded(multiply)
        }

        btn_plus.setOnClickListener {
            input_display.text = addInput("+")
            operatorAdded(add)

        }

        btn_minus.setOnClickListener {
            input_display.text = addInput("-")
            operatorAdded(subtract)

        }

        btn_decimal.setOnClickListener {
            input_display.text = addInput(".")

        }

        btn_divide.setOnClickListener {
            input_display.text = addInput("/")
            operatorAdded(divide)

        }
        btn_equals.setOnClickListener {
            val equation = input_display.text
            val equationList = equation.split("")
            if (doesContainOperator() && equationList.size == 3 && equationList[equationList.lastIndex] != "") {
                val result =
                    doMath(equationList[1], equationList[0].toFloat(), equationList[2].toFloat())
                output_display.text = result
            }
        }



    }
    private fun numberAdded (number: Float){
        if (output_display.text.isNotBlank()){
            output_display.text=""
        }
        val updatedText = "${input_display.text}"
        output_display.text= updatedText
    }

    private fun operatorAdded(operator: String) {
        if (!doesContainOperator() && input_display.text.isNotBlank()) {
            val equationString = "${input_display.text}$operator"
            input_display.text = equationString
        }
    }

    private fun doesContainOperator(): Boolean {
        return input_display.text.contains(multiply)
                || input_display.text.contains(divide)
                || input_display.text.contains(add)
                || input_display.text.contains(subtract)

    }

    private fun Float.toFormattedString(): String {
        var num = this.toString()
        if (num.endsWith(".0")) {
            num = num.substring(0, num.length - 2)
        }
        return num
    }


    private fun doMath(operator: String?, num1: Float, num2: Float): String {
        var result = 0f
        when (operator) {
            add -> result = num1 + num2
            subtract -> result = num1 - num2
            multiply -> result = num1 * num2
            divide -> result = num1 / num2
        }
        return result.toFormattedString()
    }

    companion object{
        const val TAG="CalculatorActivityLog"
        const val multiply = "*"
        const val divide = "/"
        const val add = "+"
        const val subtract = "-"

    }

}








//    private fun appendOnExpression(string:String, canClear : Boolean){
//        if(canClear){
//            output_display.text=""
//            input_display.append(string)
//        } else{
//            input_display.append(output_display.text)
//            input_display.append(string)
//            output_display.text=""
//        }
//    }

//    private fun getInputExpression(): CharSequence? {
//        var expression = input_display.text
//        return expression
//    }

//    private fun giveResult() {
//        try {
//            val expression = getInputExpression()
//            val result = Expression(expression).calculate()
//            if (result.isNaN()) {
//                // Show Error Message
//                output_display.text = "Error"
//            } else {
//                // Show Result
//                output_display.text = DecimalFormat("0.######").format(result).toString()
//            }
//        } catch (e: Exception) {
//            // Show Error Message
//            output_display.text = "Error"
//            output.setTextColor(ContextCompat.getColor(this, R.color.red))
//        }
//    }




//    private fun getOperator(): String{
//        var expression = input_display.text.replace(Regex("+"), "/")
//        expression = expression.replace(Regex("x"), "*")
//        return expression
//    }

//    private fun doMath(){
//        try{
//            val expression = getOperator()
//            val result = Expression(expression).calculate()
//            if(result.isNan()){
//                println("hello")
//            }
//            else{
//                output_display.text = DecimalFormat("0.###").format(result).toString()
//            }
//        } catch (e: Exception){
//
//        }
//
//    }


//
//





