package com.example.cryptocurrencytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.collections.ArrayList

class CustomAdapter(private var mList: ArrayList<Coin>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(), Filterable {
    var originalList = ArrayList<Coin>()

    init {
        originalList = mList
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var coinFilterList = ArrayList<Coin>()
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    coinFilterList = originalList
                } else {
                    mList.filter {
                        it.symbol?.contains(charSearch) == true
                    }.let {
                        coinFilterList.addAll(it)
                    }

                }
                val filterResults = FilterResults()
                filterResults.values = coinFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mList = results?.values as ArrayList<Coin>
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        Glide.with(holder.imageView.context!!).load(ItemsViewModel.image!!.thumb)
                .into(holder.imageView)

        holder.textView.text = ItemsViewModel.name
        holder.textView1.text = ItemsViewModel.symbol
        holder.textView2.text = ItemsViewModel.marketData!!.currentPrice!!.usd.toString()

    }

    override fun getItemCount(): Int {
        return mList.size

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.coinSymbol)
        val textView1: TextView = itemView.findViewById(R.id.coinName)
        val textView2: TextView = itemView.findViewById(R.id.priceUsd)


    }
}





