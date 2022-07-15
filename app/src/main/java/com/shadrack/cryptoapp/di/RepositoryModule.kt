package com.shadrack.cryptoapp.di

import com.shadrack.cryptoapp.data.repository.CryptoRepository
import com.shadrack.cryptoapp.data.repository.CryptoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCryptoRepository(cryptoRepositoryImpl: CryptoRepositoryImpl) : CryptoRepository

}