package com.shadrack.cryptoapp.di

import com.shadrack.cryptoapp.data.datasource.remote.CryptoApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val  BASE_URL = "https://data.messari.io/api/v1/"

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : CryptoApiService {
        return retrofit.create(CryptoApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesMoshi() : Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    }
    @Singleton
    @Provides
    fun providesRetrofit(moshi: Moshi) : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory
            .create(moshi)).build()

    }
}