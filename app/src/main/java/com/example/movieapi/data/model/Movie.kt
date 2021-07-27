package com.example.movieapi.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.time.LocalDate

@Parcelize
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
): Parcelable {
}
