package com.jason.movietvcatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.entity.ActorEntity
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id
    private val dummyActor = DataDummy.generateActorMovie(movieId)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = Resource.success(DataDummy.generateDummyMovie()[0])
        val movieEntities = MutableLiveData<Resource<MovieEntity>>()
        movieEntities.value = dummyMovie
        `when`(movieRepository.getMovieDetail(movieId)).thenReturn(movieEntities)

        val observer = mock(Observer::class.java) as Observer<Resource<MovieEntity>>
        viewModel.movieDetail.observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getActor() {
        val dummyActor = Resource.success(DataDummy.generateActorMovie(movieId))
        val actor = MutableLiveData<Resource<List<ActorEntity>>>()
        actor.value = dummyActor
        `when`(movieRepository.getMovieActors(movieId)).thenReturn(actor)

        val observer = mock(Observer::class.java) as Observer<Resource<List<ActorEntity>>>
        viewModel.actors.observeForever(observer)
        verify(observer).onChanged(dummyActor)
    }
}