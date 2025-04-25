package com.examples.kotlinlessons.oop

fun main()
{
    //val result = 5.multiply(2)//without writing infix we must use that one
    val result = 5 multiply 2//by using infix we can write that way
    println(result)
}

//we extend to integer class a new metod
//we write it here to access from everywhere
infix fun Int.multiply(num1:Int):Int
{
    return this*num1
    //this represents number which calls(uses) multiply function
}