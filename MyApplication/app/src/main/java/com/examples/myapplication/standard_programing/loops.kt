package com.examples.myapplication.standard_programing

fun main()
{
    //from 0 to 10 it increments 1 by 1
    for (i in 0..10)
    {
        println("Current i value is $i")
    }
    println("----------")
    //from 0 to 10 it increments 2 by 2 as step is 2
    for (i in 0..10 step 2)
    {
        println("Current i value is $i")
    }
    println("----------")
    //from 10 to 0 it decreases 1 by 1
    for (i in 10 downTo 0)
    {
        println("Current i value is $i")
    }
    println("----------")
    //from 10 to 0 it decreases 2 by 2 as step is 2
    for (i in 10 downTo 0 step 2)
    {
        println("Current i value is $i")
    }

    var counter = 1
    while(counter < 10)//generally we do not use <= or >= bcs it can be problem in usage of arrays
    {
        if(counter == 3)
        {
            counter++
            continue
        }
        else if(counter == 5)
            break //stops loop and contines from end of loop
        println("Number is $counter")
        counter++
    }
}