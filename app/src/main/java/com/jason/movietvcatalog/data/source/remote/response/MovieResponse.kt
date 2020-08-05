package com.jason.movietvcatalog.data.source.remote.response

import android.os.Parcel
import android.os.Parcelable

data class MovieResponse(
    var id: String?,
    var title: String?,
    var poster_path: String?,
    var release_date: String?,
    var runtime: Int?,
    var status: String?,
    var vote_average: Float?,
    var genres: List<GenreResponse>?,
    var overview: String?,
    var backdrop_path: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Float,
        arrayListOf<GenreResponse>().apply {
            parcel.readList(this as List<*>, GenreResponse::class.java.classLoader)
        },
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeValue(runtime)
        parcel.writeString(status)
        parcel.writeValue(vote_average)
        parcel.writeString(overview)
        parcel.writeString(backdrop_path)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResponse {
            return MovieResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResponse?> {
            return arrayOfNulls(size)
        }
    }


}