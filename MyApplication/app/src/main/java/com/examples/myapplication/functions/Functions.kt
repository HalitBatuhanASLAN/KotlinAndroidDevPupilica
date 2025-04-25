package com.examples.myapplication.functions

class Functions
{
    /*this one does not return anythşng(void-unit)*/
    fun welcomeMessage1()
    {
        val message = "Welcome user"
        println(message)
    }
    /*this one return a String type*/
    fun welcomeMessage2(): String
    {
        val message = "Welcome user"
        return message
    }
    /*this one takes parameter in String type*/
    fun welcomeMessage3(name:String)
    {
        println("Welcome $name")
    }

    fun summation(num1:Int,num2:Int)
    {
        println("Result is ${num1+num2}")
    }
    /*overloadin of a function(same name different parameter types or number)*/
    fun summation(num1:Double,num2:Double)
    {
        println("Result is ${num1+num2}")
    }
    /*overloadin of a function(same name different parameter types or number)*/
    fun summation(num1:Int,num2:Int,num3:Int)
    {
        println("Result is ${num1+num2+num3}")
    }
}