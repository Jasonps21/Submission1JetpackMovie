package com.jason.movietvcatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.LocalDataSource
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.ApiResponse
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource
import com.jason.movietvcatalog.data.source.remote.response.ActorResponse
import com.jason.movietvcatalog.data.source.remote.response.MovieResponse
import com.jason.movietvcatalog.data.source.remote.response.TvResponse
import com.jason.movietvcatalog.utils.AppExecutors
import kotlin.collections.ArrayList

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            local: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, local, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()

                for (response in data) {
                    val movie =
                        MovieEntity(
                            response.id!!.toInt(),
                            response.title,
                            response.posterPath,
                            response.releaseDate,
                            response.runtime,
                            response.status,
                            response.voteAverage,
                            response.genres?.joinToString { it.name },
                            response.overview,
                            response.backdropPath,
                            "movie"
                        )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvResponse>) {
                val movieList = ArrayList<MovieEntity>()

                for (response in data) {
                    val movie =
                        MovieEntity(
                            response.id!!.toInt(),
                            response.name,
                            response.poster_path,
                            response.first_air_date,
                            response.episode_run_time?.get(0),
                            response.status,
                            response.vote_average,
                            "",
                            response.overview,
                            response.backdrop_path,
                            "tvshow"
                        )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean = data?.status == null || data.runtime == null || data.genre == null

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieResponse) {
                val movie =
                    MovieEntity(
                        data.id!!.toInt(),
                        data.title,
                        data.posterPath,
                        data.releaseDate,
                        data.runtime,
                        data.status,
                        data.voteAverage,
                        data.genres?.joinToString { it.name },
                        data.overview,
                        data.backdropPath,
                        "movie"
                    )
                localDataSource.updateMovie(movie)
            }

        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, TvResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieDetail(tvShowId)

            override fun shouldFetch(data: MovieEntity?): Boolean = data?.status == null || data.runtime == null || data.genre == null

            override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: TvResponse) {
                val tvShow =
                    MovieEntity(
                        data.id!!.toInt(),
                        data.name,
                        data.poster_path,
                        data.first_air_date,
                        data.episode_run_time?.get(0),
                        data.status,
                        data.vote_average,
                        data.genres?.joinToString { it.name },
                        data.overview,
                        data.backdrop_path,
                        "tvshow"
                    )
                localDataSource.updateMovie(tvShow)
            }
        }.asLiveData()
    }

    override fun getMovieActors(movieId: Int): LiveData<Resource<List<ActorEntity>>> {
        return object :
            NetworkBoundResource<List<ActorEntity>, List<ActorResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<ActorEntity>> =
                localDataSource.getAllActorsByMovie(movieId)

            override fun shouldFetch(data: List<ActorEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ActorResponse>>> =
                remoteDataSource.getMovieActor(movieId)

            override fun saveCallResult(data: List<ActorResponse>) {
                val actorList = ArrayList<ActorEntity>()
                for (response in data) {
                    val actor = ActorEntity(0, response.character, response.profile_path, response.name, movieId)
                    actorList.add(actor)
                }
                localDataSource.insertActors(actorList)
            }
        }.asLiveData()
    }

    override fun getMoviesFavorite(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getTvShowsFavorite(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) = appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

}