package com.examples.kotlinlessons.oop

data class Foods(var id:Int,var name:String,var price:Int)
{
    init
    {
        println("New object created with id ${id}")
    }
    fun indormations()
    {
        println("Id    : ${this.id}")//this corrspondings to class which it is inside switch için self
        println("Name  : ${name}")
        println("Price : ${price}")
    }

}