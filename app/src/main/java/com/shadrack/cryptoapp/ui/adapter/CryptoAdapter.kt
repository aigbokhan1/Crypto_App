package com.shadrack.cryptoapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.cryptoapp.R
import com.shadrack.cryptoapp.data.datasource.local.entity.CryptoItems
import kotlinx.android.synthetic.main.crypto_items.view.*
import java.math.RoundingMode
import java.text.DecimalFormat

class CryptoAdapter(var cryptoItems :  List<CryptoItems>)
    : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {


    inner class CryptoViewHolder (val view : View, val cryptoList: List<CryptoItems>)
        : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {
            if (itemCount != 0) {
                view.textview_slug.text = cryptoList.get(position).slug
                view.textview_symbol.text = cryptoList.get(position).symbol
                view.textview_price.text = roundOffDecimal(cryptoList.get(position)
                    .metrics!!.market_data!!.price_usd)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.crypto_items, parent,
                false
            )

            return CryptoViewHolder(view, cryptoItems)
        }


        override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
            holder.bind(position)
        }


        override fun getItemCount(): Int = cryptoItems.size


    fun roundOffDecimal(price_usd : Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(price_usd)
    }


}
