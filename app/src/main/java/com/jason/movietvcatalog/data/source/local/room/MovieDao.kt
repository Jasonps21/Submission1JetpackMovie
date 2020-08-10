package com.jason.movietvcatalog.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities WHERE category = 'movie'")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE category = 'tvshow'")
    fun getTvShows(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE category = 'movie' AND isFavorite = 1 ")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE category = 'tvshow' AND isFavorite = 1 ")
    fun getFavoriteTvShows(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieEntity>)

    @Update
    fun updateMovies(movie: MovieEntity)

    @Query("SELECT * FROM actorentities WHERE movieId = :movieId")
    fun getActorByMovieId(movieId: Int): LiveData<List<ActorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActors(actor: List<ActorEntity>)
}