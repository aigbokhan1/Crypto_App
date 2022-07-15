package com.shadrack.cryptoapp.ui.adapter;


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.cryptoapp.R

import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems;
import kotlinx.android.synthetic.main.wallet_items.view.*
import java.math.RoundingMode
import java.text.DecimalFormat


class WalletAdapter(var cryptoItems : kotlin.collections.List<CryptoItems>) :
        RecyclerView.Adapter<WalletAdapter.WalletViewHolder>() {

        inner class WalletViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var wallettextviewslug = view.slug_txtView
        var wallettextviewsymbol = view.symbol_txtView
        var wallettextviewprice = view.price_txtView

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wallet_items,parent, false)
        return WalletViewHolder(view)
        }

        override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        val listitems = cryptoItems[position]
        holder.wallettextviewslug.text = listitems.slug
        holder.wallettextviewsymbol.text = listitems.symbol
        holder.wallettextviewprice.text = roundOffDecimal(listitems
        .metrics.market_data.price_usd)

        }

        override fun getItemCount(): Int {
        return cryptoItems.size
        }

        fun roundOffDecimal(price_usd : Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(price_usd)
        }
}