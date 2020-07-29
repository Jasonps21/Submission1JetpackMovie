package com.jason.movietvcatalog.data

import android.os.Parcel
import android.os.Parcelable

data class MovieEntity(
    var id: String?,
    var name: String?,
    var imagePath: Int?,
    var yearRelease: String?,
    var duration: String?,
    var director: String?,
    var description: String?,
    var score: String?,
    var genre: String?,
    var backdrop: Int?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeValue(imagePath)
        parcel.writeString(yearRelease)
        parcel.writeString(duration)
        parcel.writeString(director)
        parcel.writeString(description)
        parcel.writeString(score)
        parcel.writeString(genre)
        parcel.writeValue(backdrop)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieEntity> {
        override fun createFromParcel(parcel: Parcel): MovieEntity {
            return MovieEntity(parcel)
        }

        override fun newArray(size: Int): Array<MovieEntity?> {
            return arrayOfNulls(size)
        }
    }

}
