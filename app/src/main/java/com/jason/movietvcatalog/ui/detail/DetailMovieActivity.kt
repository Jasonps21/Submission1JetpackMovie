package com.jason.movietvcatalog.ui.detail

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.MovieEntity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val adapter = DetailMovieAdapter()
        val extras = intent.extras
        if (extras != null){
            val movieId =  extras.getString(EXTRA_MOVIE)
            val category =  extras.getInt(EXTRA_CATEGORY)
            if(movieId != null){
                viewModel.setSelectedMovie(movieId)
                val actor = viewModel.getActor()
                adapter.setActor(actor)
                populateMovie(viewModel.getMovieDetail(category, this))
            }
        }
        with(rv_actor){
            layoutManager = LinearLayoutManager(this@DetailMovieActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            this.adapter = adapter

        }
    }

    private fun populateMovie(movieEntity: MovieEntity){
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = movieEntity.name
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.text_dialog), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.head_title_dialog), null).show()
        }
        Glide.with(this@DetailMovieActivity)
            .load(movieEntity.backdrop)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_backdrop)
        Glide.with(this@DetailMovieActivity)
            .load(movieEntity.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_poster)
        sinopsis.text =  movieEntity.description
        genre.text=  movieEntity.genre
        release_year.text = movieEntity.yearRelease
        duration.text = movieEntity.duration
        director.text = movieEntity.director
    }
}