package com.jason.movietvcatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovieDetail(kategori: Int): LiveData<MovieEntity> {
        lateinit var movie: LiveData<MovieEntity>
        when (kategori) {
            R.string.movie -> movie = movieRepository.getMovieDetail(movieId.toInt())
            R.string.tvshow -> movie = movieRepository.getTvshowDetail(movieId.toInt())
        }
        return movie
    }

    fun getActor(): LiveData<List<ActorEntity>> = movieRepository.getMovieActors(movieId.toInt())
}