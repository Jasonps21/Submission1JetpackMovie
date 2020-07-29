package com.jason.movietvcatalog.ui.detail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.ActorEntity
import com.jason.movietvcatalog.data.MovieEntity
import com.jason.movietvcatalog.ui.movie.MovieFragment
import com.jason.movietvcatalog.ui.tvshow.TvshowFragment
import com.jason.movietvcatalog.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovieDetail(kategori: Int, context: Context): MovieEntity{
        lateinit var movie: MovieEntity
        when (kategori) {
            R.string.movie -> {
                val movieEntities = DataDummy.generateDummyMovie()
                for(movieEntity in movieEntities){
                    if(movieEntity.id == movieId){
                        movie = movieEntity
                    }
                }
            }
            R.string.tvshow -> {
                val tvshowEntities = DataDummy.generateDummyTVShow()
                for(tvshowEntity in tvshowEntities){
                    if(tvshowEntity.id == movieId){
                        movie = tvshowEntity
                    }
                }
            }
        }
        return movie
    }

    fun getActor(): List<ActorEntity> = DataDummy.generateActorMovie(movieId)
}