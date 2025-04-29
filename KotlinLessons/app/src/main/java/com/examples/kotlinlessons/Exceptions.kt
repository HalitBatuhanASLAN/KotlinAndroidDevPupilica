package com.examples.kotlinlessons

fun main()
{
    //1- compile error
    val num = 10
    //num = 30 compile error

    //2- runtime error(Exceptions)
    val x = 10
    val y = 0
    try {
        println("Result = ${x/y}")
    }catch (e: Exception)
    {
        println("Second num can not be 0(zero)")
    }


}