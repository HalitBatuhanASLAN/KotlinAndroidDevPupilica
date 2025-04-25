package com.examples.homeworks.homework2

class MyFunctions
{
    fun toFahrenhiet(centigradeDegree: Double): Double
    {
        return centigradeDegree*1.8 + 32
    }

    fun perimeter(edge1: Double,edge2: Double): Double
    {
        if(edge2 <= 0 || edge1 <= 0)
            return 0.0
        return (edge1 + edge2 ) *2
    }

    fun factorial(number: Int): Int
    {
        if (number < 0)
        {
            return 0
        }
        else if (number == 1 || number == 0)
            return 1
        else
            return number * factorial(number-1)
    }

    fun findAInText(text:String): Int
    {
        var counter = 0
        for(i in text.indices)
        {
            if (text[i] == 'a')
                counter++
        }
        return counter
    }

    fun InteriorAngles(numberOfEdge:Int): Int
    {
        if(numberOfEdge < 3)
            return -1
        return (numberOfEdge - 2) * 180
    }

    fun salaryCalculator(numOfDays:Int): Int
    {
        //Each day can work 8 ours
        //After 160hours(20day) it becomes shift
        //Normla hours 10$ shift hours 20
        fun calculateShiftSalary(ShiftDayNumber:Int):Int
        {
            return ShiftDayNumber * 8 * 20
        }
        val salary = 0
        if(numOfDays <= 0)
            return 0
        else if(numOfDays <= 20)
            return 10*8*numOfDays
        else
        {
            return (10*8*20) + calculateShiftSalary(numOfDays-20)
        }

    }

    fun billCalculator(usedGB:Int): Int
    {
        if(usedGB <= 0)
            return 0
        else if (usedGB < 51)
            return 100
        else
            return 100 + (usedGB - 50)*4
    }
}