package com.jason.movietvcatalog.ui.movie

import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.data.MovieEntity
import com.jason.movietvcatalog.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}