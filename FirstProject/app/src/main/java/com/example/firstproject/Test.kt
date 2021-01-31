package com.example.firstproject

fun main() {
 val myPhone = MobilePhone("ios","Apple", "X")

}

class MobilePhone(var osName:String, var brand:String,var model:String) {
    var charge: Int = 20

    init {
        println("The phone $brand modele $model use $osName as operating system")
        chargeBattery(30)
    }

    fun chargeBattery(a: Short) {
        println("before charge is $charge , add $a , Now charhe is ${charge+a}  ")
        this.charge += a
    }
}

