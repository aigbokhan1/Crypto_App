package com.shadrack.cryptoapp.data.datasource.local.dao

import androidx.room.*
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems

@Dao
interface CryptoDao {
    @Query("SELECT * FROM crypto_table")
    fun getCryptoItemsLocal() : List<CryptoItems>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveCryptoItems(cryptoItems: CryptoItems)

    @Delete
    fun delete(cryptoItems: CryptoItems)
}