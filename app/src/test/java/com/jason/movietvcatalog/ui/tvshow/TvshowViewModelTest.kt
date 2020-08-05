package com.jason.movietvcatalog.ui.tvshow

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
class TvshowViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel(movieRepository)
    }

    @Test
    fun getTvshow() {
        val dummyTvshows = DataDummy.generateDummyTVShow()
        val tvshows = MutableLiveData<List<MovieEntity>>()
        tvshows.value = dummyTvshows
        `when`(movieRepository.getAllTvshows()).thenReturn(tvshows)
        val tvshowEntities = viewModel.getTvshow().value
        verify<MovieRepository>(movieRepository).getAllTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(6, tvshowEntities?.size)

        viewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyTvshows)
    }
}