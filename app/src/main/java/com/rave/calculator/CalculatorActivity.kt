package com.rave.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class CalculatorActivity : AppCompatActivity() {
    private lateinit var equationTv: TextView
    private lateinit var answerTv: TextView
    private lateinit var zeroBtn: Button
    private lateinit var oneBtn: Button
    private lateinit var twoBtn: Button
    private lateinit var threeBtn: Button
    private lateinit var fourBtn: Button
    private lateinit var fiveBtn: Button
    private lateinit var sixBtn: Button
    private lateinit var sevenBtn: Button
    private lateinit var eightBtn: Button
    private lateinit var nineBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var divideBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var subtractBtn: Button
    private lateinit var addBtn: Button
    private lateinit var equalsBtn: Button
    private lateinit var deleteButton: Button
    private lateinit var decimalBtn: Button

    val viewModel by lazy { ViewModelProvider(this).get(CalculatorViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initViews()
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        zeroBtn.setOnClickListener {
            numberButtonClicked(0f)
        }
        oneBtn.setOnClickListener {
            numberButtonClicked(1f)
        }
        twoBtn.setOnClickListener {
            numberButtonClicked(2f)
        }
        threeBtn.setOnClickListener {
            numberButtonClicked(3f)
        }
        fourBtn.setOnClickListener {
            numberButtonClicked(4f)
        }
        fiveBtn.setOnClickListener {
            numberButtonClicked(5f)
        }
        sixBtn.setOnClickListener {
            numberButtonClicked(6f)
        }
        sevenBtn.setOnClickListener {
            numberButtonClicked(7f)
        }
        eightBtn.setOnClickListener {
            numberButtonClicked(8f)
        }
        nineBtn.setOnClickListener {
            numberButtonClicked(9f)
        }
        clearBtn.setOnClickListener {
            clear()
        }
        divideBtn.setOnClickListener {
            operatorButtonClicked(divide)
        }
        multiplyBtn.setOnClickListener {
            operatorButtonClicked(multiply)
        }
        subtractBtn.setOnClickListener {
            operatorButtonClicked(subtract)
        }
        addBtn.setOnClickListener {
            operatorButtonClicked(add)
        }
        equalsBtn.setOnClickListener {
            val equation = equationTv.text
            val equationList = equation.split(" ")
            if (viewModel.doesContainOperator(equationTv.text) && equationList.size == 3 && equationList[equationList.lastIndex] != "") {
                val result = viewModel.doMath(equationList[1], equationList[0].toFloat(), equationList[2].toFloat())
                answerTv.text = result
            }
        }
        deleteButton.setOnClickListener {
            val equation = equationTv.text
            val newEquation: String
            if (viewModel.doesContainOperator(equationTv.text) && equation[equation.lastIndex].toString() == " ") {
                newEquation = equation.substring(0, equation.length - 3)
                equationTv.text = newEquation
            } else {
                newEquation  = equation.substring(0, equation.length - 1)
                equationTv.text = newEquation
            }
        }
        decimalBtn.setOnClickListener {
            Log.d(TAG, "initOnClickListeners: decimal clicked")
        }
    }

    private fun numberButtonClicked(number: Float) {
        if (answerTv.text.isNotBlank()) {
            clear()
        }
        val newText = "${equationTv.text}${number.toFormattedString()}"
        equationTv.text = newText
    }

    private fun operatorButtonClicked(operator: String) {
        if (!viewModel.doesContainOperator(equationTv.text) && equationTv.text.isNotBlank()) {
            val equationString = "${equationTv.text} $operator "
            equationTv.text = equationString
        }
    }

    private fun clear() {
        equationTv.text = ""
        answerTv.text = ""
    }

    private fun initViews() {
        equationTv = findViewById(R.id.equation_tv)
        answerTv = findViewById(R.id.answer_tv)
        zeroBtn = findViewById(R.id.zero_btn)
        oneBtn = findViewById(R.id.one_btn)
        twoBtn = findViewById(R.id.two_btn)
        threeBtn = findViewById(R.id.three_btn)
        fourBtn = findViewById(R.id.four_btn)
        fiveBtn = findViewById(R.id.five_btn)
        sixBtn = findViewById(R.id.six_btn)
        sevenBtn = findViewById(R.id.seven_btn)
        eightBtn = findViewById(R.id.eight_btn)
        nineBtn = findViewById(R.id.nine_btn)
        clearBtn = findViewById(R.id.clear_btn)
        divideBtn = findViewById(R.id.divide_btn)
        multiplyBtn = findViewById(R.id.multiply_btn)
        subtractBtn = findViewById(R.id.subtract_btn)
        addBtn = findViewById(R.id.add_btn)
        equalsBtn = findViewById(R.id.equals_btn)
        deleteButton = findViewById(R.id.delete_btn)
        decimalBtn = findViewById(R.id.decimal_btn)
    }

    companion object {
        const val TAG = "MainActivity"
        const val multiply = "*"
        const val divide = "/"
        const val add = "+"
        const val subtract = "-"
    }
}