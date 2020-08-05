package com.jason.movietvcatalog.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class ActorEntity (
    @SerializedName("character")
    var character: String,
    @SerializedName("profile_path")
    var profilePath: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("movie_id")
    var movieId: String
)