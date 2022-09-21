package com.rave.calculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    fun doMath(operator: String?, num1: Float, num2: Float): String {
        var result = 0f
        when (operator) {
            CalculatorActivity.add -> result = num1 + num2
            CalculatorActivity.subtract -> result = num1 - num2
            CalculatorActivity.multiply -> result = num1 * num2
            CalculatorActivity.divide -> result = num1 / num2
        }
        return result.toFormattedString()
    }

    fun doesContainOperator(value: CharSequence): Boolean {
        return value.contains(CalculatorActivity.multiply)
                || value.contains(CalculatorActivity.divide)
                || value.contains(CalculatorActivity.add)
                || value.contains(CalculatorActivity.subtract)
    }
}