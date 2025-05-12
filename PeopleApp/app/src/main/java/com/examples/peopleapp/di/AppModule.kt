package com.examples.peopleapp.di

import com.examples.peopleapp.data.dataSource.KisilerDataSource
import com.examples.peopleapp.data.entity.Kisiler
import com.examples.peopleapp.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource): KisilerRepository{
        return KisilerRepository(kisilerDataSource)
    }


    @Provides
    @Singleton
    fun provideKisilerDataSource(): KisilerDataSource{
        return KisilerDataSource()
    }

}

