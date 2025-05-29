package com.examples.finalproject.data.repo

import com.examples.finalproject.data.datasource.ChartDataSource
import com.examples.finalproject.data.entity.CRUDAnswer
import com.examples.finalproject.data.entity.ProChart

class ChartRepository(var chartDataSource: ChartDataSource) {

    suspend fun getCartItems(username: String): List<ProChart> = chartDataSource.getCartItems(username)

    suspend fun addChart(yemek_adi : String,
                         yemek_resim_adi : String,
                         yemek_fiyat : Int,
                         yemek_siparis_adet : Int,
                         kullanici_adi : String) = chartDataSource.addChart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    suspend fun deleteFromChart(sepet_yemek_id:Int,
                                kullanici_adi: String) = chartDataSource.deleteFromChart(sepet_yemek_id,kullanici_adi)

    suspend fun updateCartItem(
        sepet_yemek_id: Int,
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ): CRUDAnswer {
        return try {
            deleteFromChart(sepet_yemek_id, kullanici_adi)
            addChart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
        } catch (e: Exception) {
            CRUDAnswer(0, "Güncelleme hatası: ${e.message}")
        }
    }

}