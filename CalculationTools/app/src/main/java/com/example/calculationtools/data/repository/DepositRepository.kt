package com.example.calculationtools.data.repository

import com.example.calculationtools.data.Calculator

class DepositRepository {
    var calculator = Calculator()

    fun depositResult(days:Int, percent:Int, money:Int):Int{

        return calculator.calculateDeposit(days, percent, money)
       // return 15

    }


}