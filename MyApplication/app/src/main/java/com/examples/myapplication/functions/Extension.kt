package com.examples.myapplication.functions

fun main()
{
    val multiplyResult = 5.multiply(10)
    println("Result is $multiplyResult")

    val summationResult = 5 summation 10
    println("Result is $summationResult")
}

//we write decleration in here(out of main) to can be access from everwhere

fun Int.multiply(number:Int):Int
{
    //this refers to number which calls that multiply function
    return this * number
}

//by writing infix we can call like
// number summation number2 instead of calling number.summation(number2)
infix fun Int.summation(number:Int):Int
{
    //this refers to number which calls that summation function
    return this + number
}