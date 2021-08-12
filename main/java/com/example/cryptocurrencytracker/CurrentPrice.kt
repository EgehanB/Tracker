package com.example.cryptocurrencytracker

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class CurrentPrice {
    @SerializedName("usd")

    var usd: Double? = null
}