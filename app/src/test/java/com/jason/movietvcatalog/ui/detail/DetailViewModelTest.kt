package com.jason.movietvcatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id.toString()
    private val dummyActor = DataDummy.generateActorMovie(movieId)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var actorObserver: Observer<List<ActorEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovieDetail() {
        viewModel.setSelectedMovie(movieId)
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie
        `when`(movieRepository.getMovieDetail(movieId.toInt())).thenReturn(movie)
        val movieEntity = viewModel.getMovieDetail(R.string.movie).value as MovieEntity
        verify(movieRepository).getMovieDetail(movieId.toInt())
        assertNotNull(dummyMovie)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.name, movieEntity.name)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.status, movieEntity.status)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.backdrop, movieEntity.backdrop)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)

        viewModel.getMovieDetail(R.string.movie).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getActor() {

        val actor = MutableLiveData<List<ActorEntity>>()
        actor.value = dummyActor
        `when`(movieRepository.getMovieActors(movieId.toInt())).thenReturn(actor)
        val actorEntities = viewModel.getActor().value
        assertNotNull(actorEntities)
        assertEquals(7, actorEntities?.size)

        viewModel.getActor().observeForever(actorObserver)
        Mockito.verify(actorObserver).onChanged(dummyActor)
    }
}