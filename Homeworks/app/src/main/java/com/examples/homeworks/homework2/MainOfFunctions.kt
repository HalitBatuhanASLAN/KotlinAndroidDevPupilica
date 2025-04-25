package com.examples.homeworks.homework2

fun main()
{
    val functionTester = MyFunctions()
    println("100 degree equals ${functionTester.toFahrenhiet(100.0)} fahrenheit")
    println("Perimeter is ${functionTester.perimeter(20.0,4.0)}")
    println("Factoail of 5 is ${functionTester.factorial(5)}")
    val text = "Cars are good thingsA"
    println("There are ${functionTester.findAInText(text)} 'a''s in $text")
    println("Sun of interior angles of a thing with 5 edges is ${functionTester.InteriorAngles(5)}")
    println("Your salary after working 24 days is ${functionTester.salaryCalculator(24)}")
    println("Your internet bill is ${functionTester.billCalculator(54)} dolars after using 54 GB")
}