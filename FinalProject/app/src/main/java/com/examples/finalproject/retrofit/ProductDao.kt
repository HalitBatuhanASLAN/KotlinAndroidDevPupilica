package com.examples.finalproject.retrofit

import com.examples.finalproject.data.entity.CRUDAnswer
import com.examples.finalproject.data.entity.CartAnswer
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

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getCartItems(@Field("kullanici_adi") username: String): CartAnswer

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addChart( @Field("yemek_adi") foodName: String,
                          @Field("yemek_resim_adi") foodImageName: String,
                          @Field("yemek_fiyat") foodPrice: Int,
                          @Field("yemek_siparis_adet") quantity: Int,
                          @Field("kullanici_adi") username: String) : CRUDAnswer

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFromChart(@Field("sepet_yemek_id") foodId : Int,
                                @Field("kullanici_adi") username: String): CRUDAnswer
}