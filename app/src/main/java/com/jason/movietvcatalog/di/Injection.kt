package com.jason.movietvcatalog.di

import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieRepository.getInstance(remoteDataSource)
    }
}