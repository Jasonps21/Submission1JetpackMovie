package com.jason.movietvcatalog.`interface`

import com.jason.movietvcatalog.data.MovieEntity

interface OnItemClickCallback {
    fun onItemClicked(data: MovieEntity)
}