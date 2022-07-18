package com.shadrack.cryptoapp.ui.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.cryptoapp.R
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import com.shadrack.cryptoapp.ui.adapter.CryptoAdapter
import com.shadrack.cryptoapp.ui.viewmodel.CryptoViewModel
import com.shadrack.cryptoapp.util.Constants.fields
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val cryptoViewModel : CryptoViewModel by viewModels()
    private lateinit var cryptoAdapter: CryptoAdapter
    private lateinit var runnable: Runnable
    private var handler : Handler = Handler()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptoViewModel.getCryptoRemote(fields)
        cryptoViewModel.getCryptoLocal()
        setUpRecyclerView()

        btn_wallet.setOnClickListener {
            val intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
        }

        btn_buy.setOnClickListener {
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }

        btn_sell.setOnClickListener {
            val intent = Intent(this, SellActivity::class.java)
            startActivity(intent)
        }

    }


    //cryptoItems var is created and passed to the adapter or you can also use (it) in replacement
    //for cryptoItems. Call the setUpRecyclerView() inside the MainActivity

    fun setUpRecyclerView(){
        cryptoViewModel.cryptoItems.observe(this){cryptoItems ->
            Log.d("cryptoItems", "setUpObservers: $cryptoItems")
            cryptoAdapter = CryptoAdapter(cryptoItems)
            var recyclerView = findViewById<RecyclerView>(R.id.crypto_recyclerview)
                recyclerView.adapter = cryptoAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

