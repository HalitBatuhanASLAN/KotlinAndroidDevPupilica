package com.examples.finalproject.data.datasource

import android.util.Log
import com.examples.finalproject.data.entity.CartAnswer
import com.examples.finalproject.data.entity.ProChart
import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.retrofit.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Field
import kotlin.collections.List

class ChartDataSource(var productDao: ProductDao) {

    suspend fun getCartItems(username: String) : List<ProChart> = withContext(Dispatchers.IO){
        return@withContext try {

            val response = productDao.getCartItems(username)

            if (response.success.toInt() == 1) {
                response.sepet_yemekler ?: emptyList()
            } else {
                emptyList()
            }

        } catch (e: Exception) {
            when (e) {
                is retrofit2.HttpException -> {
                }
                is java.net.UnknownHostException -> {
                }
                is com.google.gson.JsonSyntaxException -> {
                }
            }

            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun addChart(yemek_adi : String,
                         yemek_resim_adi : String,
                         yemek_fiyat : Int,
                         yemek_siparis_adet : Int,
                         kullanici_adi : String) = withContext(Dispatchers.IO) {
                             return@withContext productDao.addChart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }

    suspend fun deleteFromChart(sepet_yemek_id:Int,
                                kullanici_adi: String) = withContext(Dispatchers.IO) {
                                    return@withContext productDao.deleteFromChart(sepet_yemek_id,kullanici_adi)
    }
}