package com.example.flixter


import com.google.gson.annotations.SerializedName


class movie {

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("poster_path")
    var movieImageUrl: String? = null

}




