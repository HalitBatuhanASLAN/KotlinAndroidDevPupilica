package com.examples.kotlinlessons.standard_programing

fun main()
{
    val age = 20
    if(age >= 18)
    {
        println("You are full age")
    }
    else
        println("You are not full of age")

    val userName = "admin"
    val password = 123456
    if(userName == "admin" && password == 123456)
        println("Welcome to system")
    else
        println("Unsuccessfull entry")

    val number = 5
    when(number)
    {
        1->
        {
            println("Number is 1")
        }
        2-> println("Number is 2")
        else -> println("Undefined number")
    }
}