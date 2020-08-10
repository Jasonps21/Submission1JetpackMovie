package com.jason.movietvcatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int){
        this.movieId.value = movieId
    }

    var movieDetail: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getMovieDetail(mMovieId)
    }

    var tvShowDetail: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mTvShowId ->
        movieRepository.getTvShowDetail(mTvShowId)
    }

    var actors: LiveData<Resource<List<ActorEntity>>> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getMovieActors(mMovieId)
    }

    fun setFavorite(category: Int) {
        val resource =  when(category){
            R.string.movie -> movieDetail.value
            R.string.tvshow -> tvShowDetail.value
            else -> null
        }
        if (resource != null) {
            val movieDetail = resource.data
            if (movieDetail != null) {
                val newState = !movieDetail.isFavorite
                movieRepository.setFavoriteMovie(movieDetail, newState)
            }
        }
    }
}