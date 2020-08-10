package com.jason.movietvcatalog.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jason.movietvcatalog.vo.Resource
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.MovieRepository
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
class TvShowViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShow() {

        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(6)

        val tvShows = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        tvShows.value = dummyTvShows
        `when`(movieRepository.getAllTvShows()).thenReturn(tvShows)
        val tvshowEntities = viewModel.getTvshow().value?.data
        verify<MovieRepository>(movieRepository).getAllTvShows()
        assertNotNull(tvshowEntities)
        assertEquals(6, tvshowEntities?.size)

        viewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}