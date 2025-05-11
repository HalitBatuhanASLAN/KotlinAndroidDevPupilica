package com.examples.movieapp

import kotlinx.serialization.Serializable

data class Filmler(var id:Int,
    var ad: String,
    var resim:String,
    var fiyat: Int): java.io.Serializable{

}