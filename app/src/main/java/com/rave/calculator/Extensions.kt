package com.rave.calculator

 fun Float.toFormattedString(): String {
    var num = this.toString()
    if (num.endsWith(".0")) {
        num = num.substring(0, num.length - 2)
    }
    return num
}