package com.examples.homework7.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.passing(it: View,id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.passing(it: View,id: NavDirections){
    findNavController(it).navigate(id)
}