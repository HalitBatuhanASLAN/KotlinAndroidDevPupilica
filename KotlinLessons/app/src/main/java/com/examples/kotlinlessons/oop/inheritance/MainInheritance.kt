package com.examples.kotlinlessons.oop.inheritance

fun main()
{
    val animal = Animal()
    val mammal = Mammal()
    val cat = Cat()
    val dog = Dog()

    animal.voice()//no inheritance, used its method
    mammal.voice()//inheritance, used its supreclass method
    cat.voice()//inheritance, used its own method
    dog.voice()//inheritance, used its own method
    if (dog is Dog)
        println("dog is a dog")
    if (dog is Animal)
        println("dog is an animal")

    val catAnimal: Animal = Cat()
    val cat2 = catAnimal as Cat
    if (cat2 is Cat)
        println("cat2 is a cat")
}