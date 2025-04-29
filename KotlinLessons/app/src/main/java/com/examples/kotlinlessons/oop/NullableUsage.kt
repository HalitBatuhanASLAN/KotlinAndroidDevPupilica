package com.examples.kotlinlessons.oop

fun main() {
    //optional in swift
    //Nullable,Null,Safety in other languages
    //generall that topic in mobil application languages
    //null,NaN,nil uses in languages
    //generall programs crashes because of null things
    //by controlling null our systems will work better(less crashes)
    //bu using ? we say it can be null be careful
    var text: String? = null
    //text = "Welcome"

    //method 1
    //if everything is correct work,else program does not crash
    println("Method 1:${text?.toUpperCase()}")

    //method 2
    //if everything is correct work,else program crashes
    //we use it for only cases which we are sure
    println("Method 2:${text!!.toUpperCase()}")

    //method 3
    //null control
    if(text != null)
        println("Method 3:${text.toUpperCase()}")
    else
        println("text is equal to null")

    //method 4
    //null control
    //same thing with if
    text?.let{
        println("Method 4:${text.toUpperCase()}")
    }


}