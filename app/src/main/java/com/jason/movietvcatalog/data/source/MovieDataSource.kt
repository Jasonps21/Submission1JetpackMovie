package com.jason.movietvcatalog.data.source

import androidx.lifecycle.LiveData
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>
    fun getAllTvshows(): LiveData<List<MovieEntity>>
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>
    fun getTvshowDetail(tvshowId: Int): LiveData<MovieEntity>
    fun getMovieActors(movieId: Int): LiveData<List<ActorEntity>>
}