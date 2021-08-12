package com.example.cryptocurrencytracker

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coin {
    @SerializedName("id")

    var id: String? = null

    @SerializedName("symbol")

    var symbol: String? = null

    @SerializedName("name")

    var name: String? = null

    @SerializedName("asset_platform_id")

    var assetPlatformId: Any? = null

    @SerializedName("block_time_in_minutes")

    var blockTimeInMinutes: Int? = null

    @SerializedName("hashing_algorithm")

    var hashingAlgorithm: String? = null

    @SerializedName("categories")

    var categories: List<String>? = null

    @SerializedName("public_notice")

    var publicNotice: Any? = null

    @SerializedName("additional_notices")

    var additionalNotices: List<Any>? = null

    @SerializedName("image")

    var image: Image? = null

    @SerializedName("market_data")

    var marketData: MarketData? = null
}