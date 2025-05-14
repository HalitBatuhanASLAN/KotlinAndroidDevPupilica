package com.example.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import com.examples.kisileruygulamasi.room.KisilerDao
import com.examples.kisileruygulamasi.room.VeriTabani
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
    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kisilerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return KisilerDataSource(kisilerDao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao{
        //alt taraf ile rehber veri tababnına erişim sağlandı
        val veriTabani = Room.databaseBuilder(context, VeriTabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite")
            .build()
        return veriTabani.getKisilerDao()
    }
}

