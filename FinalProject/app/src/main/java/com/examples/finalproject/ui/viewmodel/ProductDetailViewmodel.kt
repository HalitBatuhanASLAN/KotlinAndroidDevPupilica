package com.examples.finalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.finalproject.data.entity.ProChart
import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.data.repo.ChartRepository
import com.examples.finalproject.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewmodel @Inject constructor(var chartRepository: ChartRepository): ViewModel() {

    var chartProductList = MutableLiveData<ProChart>()
    val cartItems = MutableLiveData<List<ProChart>>()

    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String?>()

    fun getChartItems(kullanici_adi: String) {
        isLoading.value = true
        errorMessage.value = null

        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartItems.value = chartRepository.getCartItems(kullanici_adi)
                Log.e("controll",cartItems.value.toString())

                isLoading.value = false
            } catch (e: Exception) {
                Log.e("controll sepet yükleme","aa")
                errorMessage.value = "Sepet yüklenirken hata oluştu: ${e.message}"
                cartItems.value = emptyList()
                isLoading.value = false
            }
        }
    }

    fun addChart(yemek_adi: String,
                 yemek_resim_adi: String,
                 yemek_fiyat: Int,
                 yemek_siparis_adet: Int,
                 kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
                try {
                    val res = chartRepository.addChart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
                    Log.e("controll adding res",res.success.toString())
                    Log.e("controll adding res",res.message)
                } catch (e: Exception) {
                }
            }
    }


    val existingCartItem = MutableLiveData<ProChart?>()

    // Sepette bu ürün var mı kontrol et
    fun checkProductInCart(yemek_adi: String, kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cartItems = chartRepository.getCartItems(kullanici_adi)
                val existingItem = cartItems.find { it.yemek_adi == yemek_adi }
                existingCartItem.value = existingItem
            } catch (e: Exception) {
                existingCartItem.value = null
            }
        }
    }

    // 🆕 Sepetteki ürünü güncelle
    fun updateCartItem(
        sepet_yemek_id: Int,
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = chartRepository.updateCartItem(
                    sepet_yemek_id, yemek_adi, yemek_resim_adi,
                    yemek_fiyat, yemek_siparis_adet, kullanici_adi
                )
                Log.d("UpdateCart", "Güncelleme: ${response.message}")
            } catch (e: Exception) {
                Log.e("UpdateCart", "Hata: ${e.message}")
            }
        }
    }

}