package com.example.privatcurrency

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RatesAdapter() : RecyclerView.Adapter<RatesAdapter.RateViewHolder>() {

        private val items = mutableListOf<RateUi>()

    fun submit(newItems: List<RateUi>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class RateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCurrency: TextView = view.findViewById(R.id.tvCurrency)
        val tvPurchase: TextView = view.findViewById(R.id.tvPurchase)
        val tvSale: TextView = view.findViewById(R.id.tvSale)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rate, parent, false)

        return RateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        val item = items[position]
        holder.tvCurrency.text = item.currency
        holder.tvPurchase.text = item.purchaseText
        holder.tvSale.text = item.saleText
    }

    override fun getItemCount() = items.size

}