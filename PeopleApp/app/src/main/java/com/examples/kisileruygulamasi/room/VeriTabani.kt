package com.examples.kisileruygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.data.entity.Kisiler


//alt tarafta tablo olduğunu belirttik entities kısmı ile
@Database(entities = [Kisiler::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun getKisilerDao() : KisilerDao
}