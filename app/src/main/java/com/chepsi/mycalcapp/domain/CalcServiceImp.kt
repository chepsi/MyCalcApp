package com.chepsi.mycalcapp.domain

import com.chepsi.mylibrary.Calculator

class CalcServiceImp : Calculator.Stub() {
    override fun add(a: Int, b: Int): Int {
        return a.plus(b)
    }

    override fun minus(a: Int, b: Int): Int {
        return a.minus(b)
    }

    override fun multiply(a: Int, b: Int): Int {
        return a.times(b)
    }

    override fun divide(a: Int, b: Int): Double {
        return a.div(b).toDouble()
    }
}