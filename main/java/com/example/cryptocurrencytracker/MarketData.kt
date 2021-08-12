package com.example.cryptocurrencytracker

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class MarketData {
    @SerializedName("current_price")

    var currentPrice: CurrentPrice? = null

    @SerializedName("price_change_24h")

    var priceChange24h: Double? = null
}