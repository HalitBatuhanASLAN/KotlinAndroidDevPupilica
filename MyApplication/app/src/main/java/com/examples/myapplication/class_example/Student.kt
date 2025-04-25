package com.examples.myapplication.class_example

data class Student(val name:String,var grade:Int)
{
    init
    {
        println("New object created")
    }
    fun informations()
    {
        println("Name of student is ${this.name}")
        println("Name of student is ${this.grade}")
    }
}