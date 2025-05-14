package com.examples.datastorekullanimi

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    //alt taraf dataStore kullanabilmek için nesne oluşturması gibi
    //bilgiler bizim kayıt ettiğimiz dosya
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    //statiktir
    //hepsi büüyk harflerle attan tire ile yazılır
    companion object{
        //alt tarafta key olarak SAYAC kelimesini atadık
        val SAYAC_KEY = intPreferencesKey("SAYAC")
    }

    //alttaki hem kayıt hem güncelleme
    suspend fun kayit(sayac:Int){
        context.ds.edit {
            it[SAYAC_KEY] = sayac
        }
    }

    suspend fun oku():Int{
        val p = context.ds.data.first()
        //alt tarafta nullable olma durumunda default olarak olması gereken değer verildi
        // ?: bunu kullanabiliriz bu tip durumlarda
        return p[SAYAC_KEY] ?: 0
    }

    suspend fun sil(){
        context.ds.edit {
            it.remove(SAYAC_KEY)
        }
    }
    
}