package com.jason.movietvcatalog.ui.detail

import com.jason.movietvcatalog.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id.toString()

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovieDetail() {
        viewModel.setSelectedMovie(movieId)
        val movieEntity = viewModel.getMovieDetail("movie")
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.name, movieEntity.name)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.yearRelease, movieEntity.yearRelease)
        assertEquals(dummyMovie.backdrop, movieEntity.backdrop)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.director, movieEntity.director)
    }

    @Test
    fun getActor() {
        val actorEntities = viewModel.getActor()
        assertNotNull(actorEntities)
        assertEquals(7, actorEntities.size.toLong())
    }
}