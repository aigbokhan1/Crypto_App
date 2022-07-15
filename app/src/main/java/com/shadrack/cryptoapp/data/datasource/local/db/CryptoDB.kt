package com.shadrack.cryptoapp.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shadrack.cryptoapp.data.datasource.local.dao.CryptoDao
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.util.Converters

@TypeConverters(
   Converters::class
)

@Database(entities = [CryptoItems ::class], version = 1)
abstract class CryptoDB : RoomDatabase() {

   abstract fun cryptoDao() : CryptoDao
}