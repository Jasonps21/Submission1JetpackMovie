package com.jason.movietvcatalog.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository

class TvShowViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getTvshow(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllTvShows()
}