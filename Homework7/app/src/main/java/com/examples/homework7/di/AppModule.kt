package com.examples.homework7.di

import android.content.Context
import androidx.room.Room
import com.examples.homework7.data.dataSource.ToDosDataSource
import com.examples.homework7.data.repo.ToDosRepository
import com.examples.homework7.room.DataBase
import com.examples.homework7.room.ToDosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDosRepository(toDosDataSource: ToDosDataSource): ToDosRepository{
        return ToDosRepository(toDosDataSource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(toDosDao: ToDosDao): ToDosDataSource{
        return ToDosDataSource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context): ToDosDao{
        val dataBase = Room.databaseBuilder(context, DataBase::class.java,"toDoApp.sqlite")
            .createFromAsset("toDoApp.sqlite")
            .build()
        return dataBase.getToDosDao()
    }

}