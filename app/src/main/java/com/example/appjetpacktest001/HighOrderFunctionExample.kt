package com.example.appjetpacktest001

class HighOrderFunctionExample {

    fun inchesToFeet(inches: Double) : Double {
        return inches * 0.0833333
    }

    fun inchesToYards (inches: Double) : Double {
        return inches * 0.0277778
    }

    fun outputConversion(conversionFunc: (Double) -> Double, value: Double) {
        val result = conversionFunc(value)
        println("Result = $result")
    }

    fun main01() {
        outputConversion(::inchesToFeet, 22.45)
        outputConversion(::inchesToYards, 22.45)
    }

}