package com.jason.movietvcatalog.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource
import com.jason.movietvcatalog.data.source.remote.response.ActorResponse
import com.jason.movietvcatalog.data.source.remote.response.MovieResponse
import com.jason.movietvcatalog.data.source.remote.response.TvResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {
    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(MovieResponse: List<MovieResponse>?) {
                val movieList = ArrayList<MovieEntity>()
                if (MovieResponse != null) {
                    for (response in MovieResponse) {
                        val movie =
                            MovieEntity(
                                response.id,
                                response.title,
                                response.poster_path,
                                response.release_date,
                                response.runtime,
                                response.status,
                                response.vote_average,
                                response.genres?.joinToString { it.name },
                                response.overview,
                                response.backdrop_path
                            )
                        movieList.add(movie)
                    }
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvshows(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllTvshows(object : RemoteDataSource.LoadTvshowCallback {
            override fun onAllTvshowReceived(TvshowResponse: List<TvResponse>?) {
                val movieList = ArrayList<MovieEntity>()
                if (TvshowResponse != null) {
                    for (response in TvshowResponse) {
                        val movie =
                            MovieEntity(
                                response.id,
                                response.name,
                                response.poster_path,
                                response.first_air_date,
                                response.episode_run_time?.get(0),
                                response.status,
                                response.vote_average,
                                "",
                                response.overview,
                                response.backdrop_path
                            )
                        movieList.add(movie)
                    }
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadMovieDetailCallback {
            override fun onMovieDetailReceived(MovieResponse: MovieResponse?) {
                if (MovieResponse != null) {
                    val movie =
                        MovieEntity(
                            MovieResponse.id,
                            MovieResponse.title,
                            MovieResponse.poster_path,
                            MovieResponse.release_date,
                            MovieResponse.runtime,
                            MovieResponse.status,
                            MovieResponse.vote_average,
                            MovieResponse.genres?.joinToString { it.name },
                            MovieResponse.overview,
                            MovieResponse.backdrop_path
                        )
                    movieResults.postValue(movie)
                }
            }
        })
        return movieResults
    }

    override fun getTvshowDetail(tvshowId: Int): LiveData<MovieEntity> {
        val tvshowResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getDetailTvshow(tvshowId, object : RemoteDataSource.LoadTvshowDetailCallback {
            override fun onTvshowDetailReceived(TvshowResponse: TvResponse?) {
                if (TvshowResponse != null) {
                    val tvshow =
                        MovieEntity(
                            TvshowResponse.id,
                            TvshowResponse.name,
                            TvshowResponse.poster_path,
                            TvshowResponse.first_air_date,
                            TvshowResponse.episode_run_time?.get(0),
                            TvshowResponse.status,
                            TvshowResponse.vote_average,
                            TvshowResponse.genres?.joinToString { it.name },
                            TvshowResponse.overview,
                            TvshowResponse.backdrop_path
                        )
                    tvshowResults.postValue(tvshow)
                }
            }
        })
        return tvshowResults
    }

    override fun getMovieActors(movieId: Int): LiveData<List<ActorEntity>> {
        val actorResults = MutableLiveData<List<ActorEntity>>()
        remoteDataSource.getMovieActor(movieId, object : RemoteDataSource.LoadMovieActorsCallback {
            override fun onAllMoviesActorReceived(ActorResponse: List<ActorResponse>?) {
                val actorList = ArrayList<ActorEntity>()
                if (ActorResponse != null) {
                    for (response in ActorResponse) {
                        val actor =
                            ActorEntity(
                                response.character,
                                response.profile_path,
                                response.name,
                                movieId.toString()
                            )
                        actorList.add(actor)
                    }
                }
                actorResults.postValue(actorList)
            }
        })
        return actorResults
    }
}