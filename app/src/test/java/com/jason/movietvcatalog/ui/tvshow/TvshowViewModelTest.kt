package com.jason.movietvcatalog.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel()
    }

    @Test
    fun getTvshow() {
        val tvshowEntities = viewModel.getTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(12, tvshowEntities.size)
    }
}