package com.shadrack.cryptoapp.data.repository

import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.data.datasource.remote.CryptoResponse

interface CryptoRepository {

    suspend fun getCryptoItemsLocal() : List<CryptoItems>

    suspend fun getCryptoRemote(fields : String) : CryptoResponse

    suspend fun saveCryptoItems(cryptoItems: CryptoItems)

    suspend fun deleteCryptoItems(cryptoItems: CryptoItems)


}