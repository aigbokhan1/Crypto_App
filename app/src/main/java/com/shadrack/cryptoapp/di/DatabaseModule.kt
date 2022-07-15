package com.shadrack.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.shadrack.cryptoapp.data.datasource.local.db.CryptoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CryptoDB::class.java, "crypto_db").build()

    @Singleton
    @Provides
    fun provideCryptoDao(cryptoDB: CryptoDB) = cryptoDB.cryptoDao()


}