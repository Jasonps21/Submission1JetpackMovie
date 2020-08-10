package com.jason.movietvcatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getAllTvShows(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getMoviesFavorite(): LiveData<PagedList<MovieEntity>>
    fun getTvShowsFavorite(): LiveData<PagedList<MovieEntity>>
    fun getMovieDetail(movieId: Int): LiveData<Resource<MovieEntity>>
    fun getTvShowDetail(tvShowId: Int): LiveData<Resource<MovieEntity>>
    fun getMovieActors(movieId: Int): LiveData<Resource<List<ActorEntity>>>
    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)
}