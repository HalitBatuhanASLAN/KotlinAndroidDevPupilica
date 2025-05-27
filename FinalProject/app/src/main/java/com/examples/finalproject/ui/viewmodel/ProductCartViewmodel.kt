package com.examples.finalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.finalproject.data.entity.ProChart
import com.examples.finalproject.data.repo.ChartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCartViewmodel @Inject constructor(var chartRepository: ChartRepository) : ViewModel(){

    val cartItems = MutableLiveData<List<ProChart>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String?>()

    val totalItems = MutableLiveData<Int>()
    val totalPrice = MutableLiveData<Double>()

    fun getChartItems(kullanici_adi: String) {
        isLoading.value = true
        errorMessage.value = null

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val items = chartRepository.getCartItems(kullanici_adi)
                cartItems.value = items

                calculateTotals(items)

                Log.e("controll",cartItems.value.toString())

                isLoading.value = false
            } catch (e: Exception) {
                Log.e("controll sepet yükleme","aa")
                errorMessage.value = "Sepet yüklenirken hata oluştu: ${e.message}"
                cartItems.value = emptyList()

                totalItems.value = 0
                totalPrice.value = 0.0

                isLoading.value = false
            }
        }
    }

    fun deleteFromChart(sepet_yemek_id:Int,
                        kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val res = chartRepository.deleteFromChart(sepet_yemek_id,kullanici_adi)
                Log.e("controll deleting",res.success.toString())
                Log.e("controll deleting",res.message)

                getChartItems(kullanici_adi)
            }catch (e: Exception){}
        }
    }

    private fun calculateTotals(items: List<ProChart>) {
        var itemCount = 0
        var totalCost = 0.0

        items.forEach { item ->
            itemCount += item.yemek_siparis_adet
            totalCost += (item.yemek_fiyat * item.yemek_siparis_adet)
        }

        totalItems.value = itemCount
        totalPrice.value = totalCost

        Log.d("CartTotals", "Items: $itemCount, Price: $totalCost")
    }

}