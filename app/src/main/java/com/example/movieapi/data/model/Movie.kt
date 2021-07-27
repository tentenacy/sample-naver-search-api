package com.example.movieapi.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Movie(
    @SerializedName("title")
    var title: String = "",
    @SerializedName("link")
    var link: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("pubDate")
    var pubDate: String,
    @SerializedName("director")
    var director: String = "",
    @SerializedName("actor")
    var actor: String = "",
    @SerializedName("userRating")
    var userRating: String = ""
) {

}
