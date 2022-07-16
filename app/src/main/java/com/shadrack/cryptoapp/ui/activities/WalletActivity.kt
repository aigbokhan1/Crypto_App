package com.shadrack.cryptoapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.cryptoapp.R
import com.shadrack.cryptoapp.ui.adapter.CryptoAdapter
import com.shadrack.cryptoapp.ui.adapter.WalletAdapter
import com.shadrack.cryptoapp.ui.viewmodel.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WalletActivity : AppCompatActivity() {

    private val cryptoViewModel : CryptoViewModel by viewModels()
    private lateinit var walletAdapter: WalletAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        lifecycleScope.launch() {

            setUpRecyclerViewForWallet()
        }
    }

    private fun setUpRecyclerViewForWallet(){
        cryptoViewModel.cryptoItems.observe(this){cryptoItems ->
            Log.d("cryptoItems", "setUpObservers: $cryptoItems")
            walletAdapter = WalletAdapter(cryptoItems)
            val recyclerView  = findViewById<RecyclerView>(R.id.wallet_recyclerview)
            recyclerView.layoutManager = LinearLayoutManager(this@WalletActivity)
            recyclerView.adapter = walletAdapter
        }
    }

}