package com.examples.kotlinlessons.oop

class Functions
{
    fun welcomeMessage1()//func uses is swift
    {
        val message = "Welcome user"
        println(message)
    }
    fun welcomeMessage2(): String
    {
        val message = "Welcome user"
        return message
    }

    fun welcomeMessage3(name:String)
    {
        println("Welcome $name")
    }

    fun summation(num1:Int,num2:Int)
    {
        println("Result is ${num1+num2}")
    }
    fun summation(num1:Double,num2:Double)
    {
        println("Result is ${num1+num2}")
    }
    fun summation(num1:Int,num2:Int,num3:Int)
    {
        println("Result is ${num1+num2+num3}")
    }
}