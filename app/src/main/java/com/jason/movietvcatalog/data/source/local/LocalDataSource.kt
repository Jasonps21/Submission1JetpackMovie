package com.jason.movietvcatalog.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource = INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getTvShows()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteTvShows()

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        mMovieDao.getMovieById(movieId)

    fun getAllActorsByMovie(movieId: Int): LiveData<List<ActorEntity>> =
        mMovieDao.getActorByMovieId(movieId)

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertActors(actors: List<ActorEntity>) = mMovieDao.insertActors(actors)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieDao.updateMovies(movie)
    }

    fun updateMovie(movie: MovieEntity) {
        mMovieDao.updateMovies(movie)
    }
}