package com.example.cryptocurrencytracker

import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("thumb")
    var thumb: String? = null

    @SerializedName("small")
    var small: String? = null

    @SerializedName("large")
    var large: String? = null
}
