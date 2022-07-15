package com.shadrack.cryptoapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.data.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(private val cryptoRepository : CryptoRepository) : ViewModel(){

    private val _cryptoItems = MutableLiveData<List<CryptoItems>>()
            var cryptoItems : LiveData<List<CryptoItems>> = _cryptoItems


    fun getCryptoRemote(fields : String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = cryptoRepository.getCryptoRemote(fields)


            for(i in response.data){
                saveCryptoItems(
                    CryptoItems(0, i.slug, i.symbol, i.metrics)
                )
            }
        }

    }
    fun getCryptoLocal() {
        viewModelScope.launch(Dispatchers.IO) {
            val cryptoItemsFromRoomDatabase = cryptoRepository.getCryptoItemsLocal()

            withContext(Dispatchers.Main){
                _cryptoItems.value = cryptoItemsFromRoomDatabase
            }
        }
    }


    fun saveCryptoItems(cryptoItems: CryptoItems) {
        viewModelScope.launch(Dispatchers.IO) {
            cryptoRepository.saveCryptoItems(cryptoItems)
        }

    }

    fun deleteCryptoItems(cryptoItems: CryptoItems) {
        viewModelScope.launch (Dispatchers.IO) {
            cryptoRepository.deleteCryptoItems(cryptoItems)
        }
    }


}