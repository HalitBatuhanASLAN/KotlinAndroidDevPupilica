package com.examples.kotlinlessons.collections

fun main()
{
    val fruits = ArrayList<String>()

    //adding elements end of list
    fruits.add("Apple")
    fruits.add("Banana")
    println(fruits)//we can directly write all fruits like that way

    //updating elements
    fruits[0] = "Cherry"
    println(fruits)

    //insertion an element into specific position
    fruits.add(1,"Orange")
    println(fruits)

    //getting elements
    println(fruits.get(2))

    //size
    println("Size of fruits : ${fruits.size}")

    //reversing elements
    fruits.reverse()
    println(fruits)

    for (fruit in fruits)
    {
        println(fruit)
    }

    for ((index,fruit) in fruits.withIndex())//takes index andfruit. In swift it is called enumarated()
    {
        println("$index -> $fruit")
    }

    //removes just the element with index
    fruits.removeAt(0)
    println(fruits)

    //deletes all of them
    fruits.clear()

    println(fruits)
}