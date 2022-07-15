package com.shadrack.cryptoapp.data.repository

import com.shadrack.cryptoapp.data.datasource.local.dao.CryptoDao
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.data.datasource.remote.CryptoApiService
import com.shadrack.cryptoapp.data.datasource.remote.CryptoResponse
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoDao : CryptoDao, private val cryptoApiService : CryptoApiService)
    : CryptoRepository {
    override suspend fun getCryptoItemsLocal(): List<CryptoItems> {
        return cryptoDao.getCryptoItemsLocal()
    }

    override suspend fun getCryptoRemote(fields: String): CryptoResponse {
        return cryptoApiService.getCryptoRemote(fields)
    }

    override suspend fun saveCryptoItems(cryptoItems: CryptoItems) {
        cryptoDao.saveCryptoItems(cryptoItems)
    }

    override suspend fun deleteCryptoItems(cryptoItems: CryptoItems) {
        cryptoDao.delete(cryptoItems)
    }


}