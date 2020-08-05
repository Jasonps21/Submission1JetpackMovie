package com.jason.movietvcatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource
import com.jason.movietvcatalog.utils.DataDummyRepository
import com.jason.movietvcatalog.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummyRepository.generateDummyMovie()
    private val tvshowResponses = DataDummyRepository.generateDummyTVShow()
    private val movieId = movieResponses[0].id.toString()
    private val tvshowId = tvshowResponses[0].id.toString()
    private val actorResponses = DataDummyRepository.generateActorMovie(movieId)

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvshows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvshowCallback)
                .onAllTvshowReceived(tvshowResponses)
            null
        }.`when`(remote).getAllTvshows(any())
        val tvshowEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvshows())
        verify(remote).getAllTvshows(any())
        assertNotNull(tvshowEntities)
        assertEquals(movieResponses.size.toLong(), tvshowEntities.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback)
                .onMovieDetailReceived(movieResponses[0])
            null
        }.`when`(remote).getDetailMovie(eq(movieId.toInt()), any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId.toInt()))
        verify(remote).getDetailMovie(eq(movieId.toInt()), any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses[0].title, movieEntities.name)
        assertEquals(movieResponses[0].overview, movieEntities.overview)
        assertEquals(movieResponses[0].status, movieEntities.status)
        assertEquals(movieResponses[0].release_date, movieEntities.releaseDate)
        assertEquals(movieResponses[0].poster_path, movieEntities.posterPath)
        assertEquals(movieResponses[0].runtime, movieEntities.runtime)
    }

    @Test
    fun getTvshowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadTvshowDetailCallback)
                .onTvshowDetailReceived(tvshowResponses[0])
            null
        }.`when`(remote).getDetailTvshow(eq(tvshowId.toInt()), any())

        val tvshowEntities = LiveDataTestUtil.getValue(movieRepository.getTvshowDetail(tvshowId.toInt()))

        verify(remote).getDetailTvshow(eq(tvshowId.toInt()), any())
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses[0].name, tvshowEntities.name)
        assertEquals(tvshowResponses[0].overview, tvshowEntities.overview)
        assertEquals(tvshowResponses[0].status, tvshowEntities.status)
        assertEquals(tvshowResponses[0].first_air_date, tvshowEntities.releaseDate)
        assertEquals(tvshowResponses[0].poster_path, tvshowEntities.posterPath)
        assertEquals(tvshowResponses[0].episode_run_time?.get(0), tvshowEntities.runtime)
    }

    @Test
    fun getMovieActors() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadMovieActorsCallback)
                .onAllMoviesActorReceived(actorResponses)
            null
        }.`when`(remote).getMovieActor(eq(movieId.toInt()), any())

        val actorEntities = LiveDataTestUtil.getValue(movieRepository.getMovieActors(movieId.toInt()))
        verify(remote)
            .getMovieActor(eq(movieId.toInt()), any())
        assertNotNull(actorEntities)
        assertEquals(actorResponses.size.toLong(), actorEntities.size.toLong())
    }
}