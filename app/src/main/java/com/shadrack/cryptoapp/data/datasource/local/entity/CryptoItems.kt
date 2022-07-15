package com.shadrack.cryptoapp.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class CryptoItems(@PrimaryKey(autoGenerate = true) val crypto_id: Int = 0, val slug : String,
                       val symbol : String, val metrics : Metrics)
