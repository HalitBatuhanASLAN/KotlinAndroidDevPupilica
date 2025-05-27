package com.examples.homework7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.examples.homework7.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class DataBase : RoomDatabase(){
    abstract fun getToDosDao() : ToDosDao
}