package com.shadrack.cryptoapp.data.datasource.remote

import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.data.datasource.local.entity.StatusItems

data class CryptoResponse(val status: StatusItems, val data: List<CryptoItems>)
