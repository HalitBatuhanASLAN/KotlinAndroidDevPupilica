package com.examples.kotlinlessons.oop

fun main()
{
    val a = ClassA()

/*

    //standard usage
    println(a.x)
    a.method()


    //it creates a virtual object(nameless object)
    println(ClassA().x)//creates first object
    ClassA().method()//creates second object

*/
    //static usage
    //in static usage we do not need paranthesis
    println(ClassA.x)
    ClassA.method()

}