package com.examples.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.entity.Kisiler


//dao = database access object
//veritabanı üzerindeki metodlar
@Dao
interface KisilerDao {
    //alt taraf okuma işlemi srgu için
    // * ile tüm alanarı getiririz kisi_ad desek sadece o alanı getirir
    // kisiler sein tablo adın
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle(): List<Kisiler>

    @Insert
    suspend fun kaydet(kisi: Kisiler)

    @Update
    suspend fun guncelle(kisi : Kisiler)

    @Delete
    suspend fun sil(kisi: Kisiler)

    //alt tarftaki kodda aşşağıdan yukarıya parametre alma işlemi uygulandı
    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%'|| :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi : String): List<Kisiler>
}