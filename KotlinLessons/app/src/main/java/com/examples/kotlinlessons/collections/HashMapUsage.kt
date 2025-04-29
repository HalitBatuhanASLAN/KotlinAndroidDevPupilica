package com.examples.kotlinlessons.collections

fun main()
{
    //in swift Dictionary equals HashMap
    //Shared Preferences, DataStore, UserDefault(in swift), JSON lokkslike HashMap

    var cities = HashMap<Int,String>()
    cities.put(6,"Angara")
    cities[34] = "istanbul"
    cities[1] = "Adana"
    println(cities)

    for((key,value) in cities)
    {
        println("${value} has ${key} license plate code")
    }

    //generally same methods are also in here like remove,clear

}