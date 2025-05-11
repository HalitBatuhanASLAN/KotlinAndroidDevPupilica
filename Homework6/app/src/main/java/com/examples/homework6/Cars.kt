package com.examples.homework6

import kotlinx.serialization.Serializable

class Cars(
    var id: Int,
    var price:Int,
    var announcementDate: String,
    var brand: String,
    var model: String,
    var year: String,
    var gearType: String,
    var picture:String,
    var city:String,
    var exchange:String,
    var kilometers:String
): java.io.Serializable
{
}