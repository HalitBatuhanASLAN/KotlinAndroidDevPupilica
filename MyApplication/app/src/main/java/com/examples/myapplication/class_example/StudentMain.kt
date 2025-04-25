package com.examples.myapplication.class_example

fun main()
{
    val student1 = Student("Ahmet",90)
    student1.informations()

    /*
    student1.name = "Mehmet"
        we can not change name as it wad declerad in class decleration as val
     */
    student1.grade = 100
    println("New grade is ${student1.grade}")
    /*we use ${} and onjectName.attribute to get relevant value*/

    println("------------")
    val student2 = Student("Ali",85)
    student2.informations()

}