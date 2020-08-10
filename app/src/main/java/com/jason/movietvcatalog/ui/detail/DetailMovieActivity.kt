package com.jason.movietvcatalog.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.jason.movietvcatalog.vo.Status
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.viewModel.ViewModelFactory
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.ApiClient
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailMovieActivity : AppCompatActivity() {

    internal lateinit var viewModel: DetailViewModel
    private var category = 0

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val adapter = DetailMovieAdapter()
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            category = extras.getInt(EXTRA_CATEGORY)

            viewModel.setSelectedMovie(movieId)
            viewModel.actors.observe(this, Observer { actorResource ->
                if (actorResource != null) {
                    when (actorResource.status) {
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            if (actorResource.data != null) {
                                adapter.setActor(actorResource.data)
                                adapter.notifyDataSetChanged()
                            }
                            progress_bar.visibility = View.GONE
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    progress_bar.visibility = View.GONE
                }
            })
            when (category) {
                R.string.movie ->
                    viewModel.movieDetail.observe(this, Observer { movieDetail ->
                        if (movieDetail != null) {
                            when (movieDetail.status) {
                                Status.LOADING -> progress_bar.visibility = View.VISIBLE
                                Status.SUCCESS -> if (movieDetail.data != null) {
                                    progress_bar.visibility = View.GONE
                                    populateMovie(movieDetail.data)
                                    val state = movieDetail.data.isFavorite
                                    setFavoriteMovie(state)
                                }
                                Status.ERROR -> {
                                    progress_bar.visibility = View.GONE
                                    Toast.makeText(
                                        applicationContext,
                                        "Terjadi kesalahan",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    })
                R.string.tvshow ->
                    viewModel.tvShowDetail.observe(this, Observer { tvShowDetail ->
                        if (tvShowDetail != null) {
                            when (tvShowDetail.status) {
                                Status.LOADING -> progress_bar.visibility = View.VISIBLE
                                Status.SUCCESS -> if (tvShowDetail.data != null) {
                                    progress_bar.visibility = View.GONE
                                    populateMovie(tvShowDetail.data)
                                    val state = tvShowDetail.data.isFavorite
                                    setFavoriteMovie(state)
                                }
                                Status.ERROR -> {
                                    progress_bar.visibility = View.GONE
                                    Toast.makeText(
                                        applicationContext,
                                        "Terjadi kesalahan",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
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
            viewModel.setFavorite(category)
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

    private fun setFavoriteMovie(state: Boolean) {
        if (state) {
            fab.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            fab.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun convertDuration(t: Int): String {
        val hours: Int = t / 60
        val minutes: Int = t % 60
        return if (t > 60) String.format("%dh %02dm", hours, minutes) else String.format(
            "%02dm",
            minutes
        )
    }
}