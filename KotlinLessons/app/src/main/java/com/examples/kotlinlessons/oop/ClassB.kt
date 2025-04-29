package com.examples.kotlinlessons.oop

class ClassB: MyInterface
{

    override var variable: Int = 100

    override fun method1()
    {
        println("method1 worked")
    }

    override fun method2(): String
    {
        return "method2 worked"
    }

}