package com.jason.movietvcatalog.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val courses = MutableLiveData<List<MovieEntity>>()
        courses.value = dummyMovies
        `when`(movieRepository.getAllMovies()).thenReturn(courses)
        val movieEntities = viewModel.getMovies().value
        verify<MovieRepository>(movieRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(6, movieEntities?.size)
        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}