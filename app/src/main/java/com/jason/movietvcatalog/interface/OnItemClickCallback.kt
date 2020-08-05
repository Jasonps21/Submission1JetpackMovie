package com.jason.movietvcatalog.`interface`

import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

interface OnItemClickCallback {
    fun onItemClicked(data: MovieEntity)
}