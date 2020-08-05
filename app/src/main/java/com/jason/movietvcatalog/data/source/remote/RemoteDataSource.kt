package com.jason.movietvcatalog.data.source.remote

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

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovies(ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                callback.onAllMoviesReceived(data?.results)
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getAllTvshows(callback: LoadTvshowCallback) {
        EspressoIdlingResource.increment()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getTvshows(ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                callback.onAllTvshowReceived(data?.results)
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getDetailMovie(movieId: Int, callback: LoadMovieDetailCallback) {
        EspressoIdlingResource.increment()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovieDetail(movieId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                callback.onMovieDetailReceived(data)
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getDetailTvshow(tvshowId: Int, callback: LoadTvshowDetailCallback) {
        EspressoIdlingResource.increment()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getTvDetail(tvshowId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()
                callback.onTvshowDetailReceived(data)
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getMovieActor(movieId: Int, callback: LoadMovieActorsCallback) {
        EspressoIdlingResource.increment()
        GlobalScope.launch(Dispatchers.IO) {
            val service: ApiService = retrofitInstance!!.create<ApiService>(ApiService::class.java)
            val response = service.getMovieCredits(movieId, ApiClient.API_KEY)
            if (response.isSuccessful) {
                val data = response.body()?.cast
                callback.onAllMoviesActorReceived(data)
                EspressoIdlingResource.decrement()
            }
        }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(MovieResponse: List<MovieResponse>?)
    }

    interface LoadTvshowCallback {
        fun onAllTvshowReceived(TvshowResponse: List<TvResponse>?)
    }

    interface LoadMovieActorsCallback {
        fun onAllMoviesActorReceived(ActorResponse: List<ActorResponse>?)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(MovieResponse: MovieResponse?)
    }

    interface LoadTvshowDetailCallback {
        fun onTvshowDetailReceived(TvshowResponse: TvResponse?)
    }
}