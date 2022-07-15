package com.shadrack.cryptoapp.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApiService {

    @GET("assets")
    suspend fun getCryptoRemote(@Query("fields") fields : String) : CryptoResponse
}