package com.examples.kotlinlessons.oop

fun main()
{
    priceCalculate(CanSize.LITTLE,12)
}

fun priceCalculate(size: CanSize,number: Int)
{
    when(size)
    {
        CanSize.LITTLE -> println("Price : ${number * 100} TL")
        CanSize.MEDIUM -> println("Price : ${number * 125} TL")
        CanSize.BIG -> println("Price : ${number * 150} TL")
    }
}