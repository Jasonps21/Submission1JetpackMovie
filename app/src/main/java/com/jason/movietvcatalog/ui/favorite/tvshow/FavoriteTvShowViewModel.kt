package com.jason.movietvcatalog.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

class FavoriteTvShowViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getTvShowsFavorite(): LiveData<PagedList<MovieEntity>> = movieRepository.getTvShowsFavorite()
}