package com.example.movieapi.data.model

import com.google.gson.annotations.SerializedName

data class ResultSearchMovie(
    @SerializedName("lastBuildDate") var lastBuildDate: String = "",
    @SerializedName("total") var total: Int = 0,
    @SerializedName("start") var start: Int = 0,
    @SerializedName("display") var display: Int = 0,
    @SerializedName("items") var items: List<Movie>
) {

}
