package com.jason.movietvcatalog.di

import android.content.Context
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.data.source.local.LocalDataSource
import com.jason.movietvcatalog.data.source.local.room.MovieRoomDatabase
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource
import com.jason.movietvcatalog.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val database = MovieRoomDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}