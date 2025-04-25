package com.examples.kotlinlessons.standard_programing

fun main()
{
    for(i in 1..3)//in switch language it is 1...3
    {
        println("Number is $i")
    }

    for(i in 10..20 step 5)//it in eanch loop increments 5
    {
        println("Number is $i")
    }

    for(i in 20 downTo 10 step 5)//downs from 20 to 10 by decrease 5 in each case
    {
        println("Number is $i")
    }

    var counter = 1
    while(counter < 4)//generally we do not use <= or >= bcs it can be problem in usage of arrays
    {
        println("Number is $counter")
        counter++
    }

    for(i in 1..5)
    {
        if(i == 3)
            break
        println("Loop num $i")
    }

    for(i in 1..5)
    {
        if(i == 3)
            continue
        println("Loop num $i")
    }
}