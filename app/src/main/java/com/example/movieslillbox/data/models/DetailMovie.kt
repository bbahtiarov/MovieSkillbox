package com.example.movieslillbox.data.models

import com.google.gson.annotations.SerializedName

data class DetailMovie(
    val id: Int,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val runtime: Int,
    val title: String,
    @SerializedName("vote_average")
    val rating: Double
)