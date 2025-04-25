package com.examples.myapplication.standard_programing

fun main()
{
    val age = 12
    if(age >= 0 && age < 18)
        println("You are child")
    else if(age >= 18 && age < 65)
        println("You are middle aged")
    else if(age >= 65)
        println("You are old")
    else
    {
        println("Your age is out of scope")
        println("Age must be grater than 0")
    }

    val choise = 2
    when(choise)
    {
        1->
        {
            println("Your choise is 1")
        }
        2->
            println("Your choise is 2")
        3->
            println("Your choise is 3")
        else -> println("Choise is not valid")
    }
}