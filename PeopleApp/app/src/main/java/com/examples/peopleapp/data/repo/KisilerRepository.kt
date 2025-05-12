package com.examples.peopleapp.data.repo

import android.util.Log
import com.examples.peopleapp.data.dataSource.KisilerDataSource
import com.examples.peopleapp.data.entity.Kisiler

class KisilerRepository(var kisilerDataSource : KisilerDataSource){

    //alt tarafta tek işlevi bu olduğu için bu şekilde bir tanımlama(fonksiyon) yaptık
    suspend fun record(name : String,tel_number: String) = kisilerDataSource.record(name,tel_number)

    suspend fun update(kisi_id:Int,kisi_ad: String,kisi_tel: String) =
        kisilerDataSource.update(kisi_id,kisi_ad,kisi_tel)

    suspend fun sil(kisi_id:Int) =
        kisilerDataSource.sil(kisi_id)

    suspend fun kisileriYukle(): List<Kisiler> = kisilerDataSource.kisileriYukle()

    suspend fun ara(aramamKelimesi: String): List<Kisiler> = kisilerDataSource.ara(aramamKelimesi)

}