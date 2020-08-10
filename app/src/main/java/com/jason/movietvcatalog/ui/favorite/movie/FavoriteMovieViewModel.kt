package com.jason.movietvcatalog.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getMoviesFavorite(): LiveData<PagedList<MovieEntity>> = movieRepository.getMoviesFavorite()
}