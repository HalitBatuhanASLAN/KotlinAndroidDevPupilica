package com.examples.kotlinlessons.variables

import kotlin.reflect.typeOf

fun main()
{
    //  println("Hello world")
    val id = 1 //we can not change it
    var name = "Coat"
    var photo = "coat.png"
    var point = 4.7
    var price = 3499
    var stock = true
    println("Id : $id")
    println("Name : $name")
    name = "Boat"
    //id = 2;

    //type casting
    // 1-number to number
    val DoubleNumber = 15.3;
    val IntNumber = DoubleNumber.toInt()
    println(IntNumber)


    // 2-number to string
    val StringNumber = IntNumber.toString()
    println(StringNumber)

    // 3-string to number
    val text = "48T"
    val IntText = text.toIntOrNull()
    println(IntText)
}