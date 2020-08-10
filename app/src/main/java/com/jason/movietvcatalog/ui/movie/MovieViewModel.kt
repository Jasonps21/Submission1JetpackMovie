package com.jason.movietvcatalog.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()
}