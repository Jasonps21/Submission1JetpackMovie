package com.jason.movietvcatalog.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.viewModel.ViewModelFactory
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.ApiClient
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

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val adapter = DetailMovieAdapter()
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val category = extras.getInt(EXTRA_CATEGORY)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                progress_bar.visibility = View.VISIBLE
                viewModel.getMovieDetail(category).observe(this, Observer { movie ->
                    progress_bar.visibility = View.GONE
                    populateMovie(movie)
                })
                viewModel.getActor().observe(this, Observer { actor ->
                    adapter.setActor(actor)
                    adapter.notifyDataSetChanged()
                })
            }
        }
        with(rv_actor) {
            layoutManager =
                LinearLayoutManager(this@DetailMovieActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = movieEntity.name
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.text_dialog), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.head_title_dialog), null).show()
        }
        Glide.with(this@DetailMovieActivity)
            .load(ApiClient.BASE_URL_IMAGE + movieEntity.backdrop)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_backdrop)
        Glide.with(this@DetailMovieActivity)
            .load(ApiClient.BASE_URL_IMAGE + movieEntity.posterPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_poster)
        sinopsis.text = movieEntity.overview
        genre.text = movieEntity.genre
        release_year.text = movieEntity.releaseDate
        duration.text = movieEntity.runtime?.let { convertDuration(it) }
        status.text = movieEntity.status
    }

    private fun convertDuration(t: Int): String{
        val hours: Int = t / 60
        val minutes: Int = t % 60
        return if (t > 60) String.format("%dh %02dm", hours, minutes) else String.format("%02dm", minutes)
    }
}