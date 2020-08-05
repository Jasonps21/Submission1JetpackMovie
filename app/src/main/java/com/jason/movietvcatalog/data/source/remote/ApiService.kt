package com.jason.movietvcatalog.data.source.remote

import com.jason.movietvcatalog.data.source.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") api_key: String): Response<ListMovieResponse>

    @GET("tv/popular")
    suspend fun getTvshows(@Query("api_key") api_key: String): Response<ListTvshowResponse>

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int, @Query("api_key") api_key: String): Response<MovieResponse>

    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(@Path("id") id: Int, @Query("api_key") api_key: String): Response<CreditResponse>

    @GET("tv/{id}")
    suspend fun getTvDetail(@Path("id") id: Int, @Query("api_key") api_key: String): Response<TvResponse>
}