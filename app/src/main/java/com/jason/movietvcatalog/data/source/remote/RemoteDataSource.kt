package com.jason.movietvcatalog.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jason.movietvcatalog.data.source.remote.ApiClient.retrofitInstance
import com.jason.movietvcatalog.data.source.remote.response.ActorResponse
import com.jason.movietvcatalog.data.source.remote.response.MovieResponse
import com.jason.movietvcatalog.data.source.remote.response.TvResponse
import com.jason.movietvcatalog.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RemoteDataSource private constructor() {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource()
        }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovies(ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null){
                    resultMovies.postValue(ApiResponse.success(data.results))
                }
                EspressoIdlingResource.decrement()
            }
        }
        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvResponse>>>()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getTvshows(ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null){
                    resultTvShows.postValue(ApiResponse.success(data.results))
                }
                EspressoIdlingResource.decrement()
            }
        }
        return resultTvShows
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovieDetail(movieId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null){
                    resultMovie.postValue(ApiResponse.success(data))
                }
                EspressoIdlingResource.decrement()
            }
        }
        return resultMovie
    }

    fun getDetailTvShow(tvshowId: Int): LiveData<ApiResponse<TvResponse>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<TvResponse>>()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getTvDetail(tvshowId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null){
                    resultTvShow.postValue(ApiResponse.success(data))
                }
                EspressoIdlingResource.decrement()
            }
        }
        return resultTvShow
    }

    fun getMovieActor(movieId: Int): LiveData<ApiResponse<List<ActorResponse>>> {
        EspressoIdlingResource.increment()
        val resultActors = MutableLiveData<ApiResponse<List<ActorResponse>>>()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovieCredits(movieId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()?.cast
                if (data != null){
                    resultActors.postValue(ApiResponse.success(data))
                }
                EspressoIdlingResource.decrement()
            }
        }
        return resultActors
    }
}