package com.jason.movietvcatalog.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository

class TvshowViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getTvshow(): LiveData<List<MovieEntity>> = movieRepository.getAllTvshows()
}