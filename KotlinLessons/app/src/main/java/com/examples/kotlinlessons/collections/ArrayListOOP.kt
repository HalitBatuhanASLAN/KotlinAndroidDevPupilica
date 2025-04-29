package com.examples.kotlinlessons.collections

fun main()
{
    val godfather = Movies(1,"God Father",50)
    val gulenGozler = Movies(2,"Gulen gozler",750)
    val hababam = Movies(3,"Hababam sinifi",1000)

    var listOfMovies = ArrayList<Movies>()
    listOfMovies.add(godfather)
    listOfMovies.add(gulenGozler)
    listOfMovies.add(hababam)

    for (movie in listOfMovies)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }

    //sorting

    //ascend-ASC means increasing
    println("Increasing in prince")
    //it refers to current element in list
    var increasingPrice = listOfMovies.sortedWith(compareBy { it.price })
    for(movie in increasingPrice)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }
    println("Increasing in name")
    var increasingName = listOfMovies.sortedWith(compareBy { it.name })
    for(movie in increasingName)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }


    //DESC means decreasing
    println("Decreasing in price")
    var decreasingPrice = listOfMovies.sortedWith(compareByDescending { it.price })
    for(movie in decreasingPrice)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }

    println("Decreasing in name")
    var DecreasingName = listOfMovies.sortedWith(compareByDescending { it.name })
    for(movie in DecreasingName)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }

    //predicate means sorgu, uses in swift

    println("------------Filtering----------")
    println("Filterin 1")
    var filter1 = listOfMovies.filter{it.price > 100 && it.price < 800 }
    for(movie in filter1)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }

    println("Filtering 2")
    var filter2 = listOfMovies.filter{it.name.contains("Fa") }
    for(movie in filter2)
    {
        println("${movie.id} : ${movie.name}, ${movie.price} TL")
    }

}