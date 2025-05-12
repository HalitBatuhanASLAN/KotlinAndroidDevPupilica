package com.examples.peopleapp.data.dataSource

import android.util.Log
import com.examples.peopleapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class KisilerDataSource {
    /*suspend ile biz bu fonksiyonun bu şekilde çalışacağını belirtiyoruz*/
    suspend fun record(name : String,tel_number: String){
        Log.e("Person added","${name}->${tel_number}")
    }

    suspend fun update(kisi_id:Int,kisi_ad: String,kisi_tel: String) {
        Log.e("Kisi güncelle","${kisi_id}->${kisi_ad}->${kisi_tel}")
    }


    suspend fun sil(kisi_id:Int){
        Log.e("Kisi sil",kisi_id.toString())
    }

    //uygulama mimarisinin en zor kısmı verilerin iletilmesi kısmıdır
    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)

        return@withContext liste
    }

    suspend fun ara(aramamKelimesi: String): List<Kisiler> = withContext(Dispatchers.IO){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        liste.add(k1)
        return@withContext liste
    }

}