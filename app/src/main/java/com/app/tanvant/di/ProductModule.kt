package com.app.tanvant.di

import android.content.Context
import androidx.room.Room
import com.app.tanvant.api.ApiService
import com.app.tanvant.db.ProductDatabase
import com.app.tanvant.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideProductDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, ProductDatabase::class.java,
        "product_db"
    ).build()

    @Singleton
    @Provides
    fun provideProductDao(
        db: ProductDatabase
    ) = db.productDao()
}