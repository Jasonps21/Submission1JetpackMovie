package com.jason.movietvcatalog.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.`interface`.OnItemClickCallback
import com.jason.movietvcatalog.ui.detail.DetailMovieActivity
import com.jason.movietvcatalog.data.MovieEntity
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(movies)

            movieAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: MovieEntity) {
                    val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                    intent.putExtra(DetailMovieActivity.EXTRA_CATEGORY,  R.string.movie)
                    startActivity(intent)
                }
            })

            with(rv_movies) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}
