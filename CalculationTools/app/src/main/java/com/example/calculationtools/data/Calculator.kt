package com.example.calculationtools.data

class Calculator {

    var days:Int =0
    var percent:Int = 0
    var money:Int = 0
    var result:Int = 0


    fun calculateDeposit(days:Int, percent:Int, money:Int) : Int{
        return (days * percent * money /365)
    }


}