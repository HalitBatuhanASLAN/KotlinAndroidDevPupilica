package com.examples.finalproject.di

import com.examples.finalproject.data.datasource.ChartDataSource
import com.examples.finalproject.data.datasource.ProductDataSource
import com.examples.finalproject.data.repo.ChartRepository
import com.examples.finalproject.data.repo.ProductRepository
import com.examples.finalproject.retrofit.ApiUtils
import com.examples.finalproject.retrofit.ProductDao
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
    fun provideProductRepository(productDataSource: ProductDataSource) : ProductRepository{
        return ProductRepository(productDataSource)
    }

    @Provides
    @Singleton
    fun provideProductDataSource(productDao: ProductDao) : ProductDataSource{
        return ProductDataSource(productDao)
    }

    @Provides
    @Singleton
    fun provideChartProductRepository(chartDataSource: ChartDataSource) : ChartRepository{
        return ChartRepository(chartDataSource)
    }

    @Provides
    @Singleton
    fun provideChartProductDataSource(productDao: ProductDao) : ChartDataSource{
        return ChartDataSource(productDao)
    }



    @Provides
    @Singleton
    fun provideProductDao(): ProductDao{
        return ApiUtils.getProductDao()
    }
}