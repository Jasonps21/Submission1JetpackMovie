package com.jason.movietvcatalog.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jason.movietvcatalog.data.source.MovieRepository
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
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
class FavoriteMovieViewModelTest {
    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMovieViewModel(movieRepository)
    }

    @Test
    fun getMoviesFavorite() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(6)

        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies
        `when`(movieRepository.getMoviesFavorite()).thenReturn(movies)
        val movieEntities = viewModel.getMoviesFavorite().value
        verify<MovieRepository>(movieRepository).getMoviesFavorite()
        assertNotNull(movieEntities)
        assertEquals(6, movieEntities?.size)

        viewModel.getMoviesFavorite().observeForever(observer)
        verify(observer).onChanged(movieEntities)
    }
}