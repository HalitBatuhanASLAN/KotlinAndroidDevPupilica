package com.examples.finalproject.retrofit

import com.examples.finalproject.data.entity.ProductsAnswer
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun uploadProduct() : ProductsAnswer


    @POST("yemekler/tumYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun search(@Field("yemek_adi") searchWord: String): ProductsAnswer
}