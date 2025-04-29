package com.examples.kotlinlessons.oop.inheritance

class Cat: Mammal()
{
    override fun voice()
    {
        //super represent the parent class
        //super.voice()
        println("Miyav miyav")
    }
}