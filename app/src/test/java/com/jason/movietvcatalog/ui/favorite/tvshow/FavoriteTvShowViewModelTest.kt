package com.jason.movietvcatalog.ui.favorite.tvshow

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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    private lateinit var viewModel: FavoriteTvShowViewModel

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
        viewModel = FavoriteTvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShowsFavorite() {
        val dummyTvShows = pagedList
        Mockito.`when`(dummyTvShows.size).thenReturn(6)

        val tvShows = MutableLiveData<PagedList<MovieEntity>>()
        tvShows.value = dummyTvShows
        Mockito.`when`(movieRepository.getTvShowsFavorite()).thenReturn(tvShows)
        val tvshowEntities = viewModel.getTvShowsFavorite().value
        Mockito.verify<MovieRepository>(movieRepository).getTvShowsFavorite()
        assertNotNull(tvshowEntities)
        assertEquals(6, tvshowEntities?.size)

        viewModel.getTvShowsFavorite().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}