package com.jason.movietvcatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.LocalDataSource
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.RemoteDataSource
import com.jason.movietvcatalog.utils.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieRepository =
        FakeMovieRepository(
            remote,
            local,
            appExecutors
        )

    private val movieResponses = DataDummyRepository.generateDummyMovie()
    private val tvshowResponses = DataDummyRepository.generateDummyTVShow()
    private val movieId = movieResponses[0].id.toString()
    private val tvshowId = tvshowResponses[0].id.toString()
    private val actorResponses = DataDummyRepository.generateActorMovie(movieId)

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))

        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(movieResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesFavorite() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieRepository.getMoviesFavorite()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))

        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowsFavorite() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getTvShowsFavorite()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))

        verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovie()[0]
        `when`(local.getMovieDetail(movieId.toInt())).thenReturn(dummyEntity)
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId.toInt()))
        verify(local).getMovieDetail(eq(movieId.toInt()))
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses[0].title, movieEntities.data?.name)
        assertEquals(movieResponses[0].overview, movieEntities.data?.overview)
        assertEquals(movieResponses[0].status, movieEntities.data?.status)
        assertEquals(movieResponses[0].releaseDate, movieEntities.data?.releaseDate)
        assertEquals(movieResponses[0].posterPath, movieEntities.data?.posterPath)
        assertEquals(movieResponses[0].runtime, movieEntities.data?.runtime)
    }

    @Test
    fun getTvShowDetail() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyTVShow()[0]
        `when`(local.getMovieDetail(tvshowId.toInt())).thenReturn(dummyEntity)
        val tvshowEntities = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(tvshowId.toInt()))
        verify(local).getMovieDetail(eq(tvshowId.toInt()))
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses[0].name, tvshowEntities.data?.name)
        assertEquals(tvshowResponses[0].overview, tvshowEntities.data?.overview)
        assertEquals(tvshowResponses[0].status, tvshowEntities.data?.status)
        assertEquals(tvshowResponses[0].first_air_date, tvshowEntities.data?.releaseDate)
        assertEquals(tvshowResponses[0].poster_path, tvshowEntities.data?.posterPath)
        assertEquals(tvshowResponses[0].episode_run_time?.get(0), tvshowEntities.data?.runtime)
    }

    @Test
    fun getMovieActors() {
        val dummyActor = MutableLiveData<List<ActorEntity>>()
        dummyActor.value = DataDummy.generateActorMovie(movieId.toInt())
        `when`(local.getAllActorsByMovie(movieId.toInt())).thenReturn(dummyActor)
        val actorEntities = LiveDataTestUtil.getValue(movieRepository.getMovieActors(movieId.toInt()))
        verify(local).getAllActorsByMovie(movieId.toInt())
        assertNotNull(actorEntities.data)
        assertEquals(actorResponses.size.toLong(), actorEntities.data?.size?.toLong())
    }
}