package com.jason.movietvcatalog.data.source.remote

import com.jason.movietvcatalog.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit: Retrofit? = null
    const val BASE_URL = BuildConfig.BASE_URL
    const val BASE_URL_IMAGE = BuildConfig.BASE_URL_IMAGE
    const val API_KEY = BuildConfig.GITHUB_TOKEN
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}