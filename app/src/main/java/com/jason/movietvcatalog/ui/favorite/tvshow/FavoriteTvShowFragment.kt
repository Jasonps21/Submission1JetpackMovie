package com.jason.movietvcatalog.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.`interface`.OnItemClickCallback
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.ui.detail.DetailMovieActivity
import com.jason.movietvcatalog.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.progress_bar
import kotlinx.android.synthetic.main.fragment_tvshow.*

class FavoriteTvShowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]
            val tvshowAdapter = FavoriteTvShowAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getTvShowsFavorite().observe(viewLifecycleOwner, Observer { tvShows ->
                progress_bar.visibility = View.GONE
                tvshowAdapter.submitList(tvShows)
                tvshowAdapter.notifyDataSetChanged()

            })

            tvshowAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: MovieEntity) {
                    val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                    intent.putExtra(DetailMovieActivity.EXTRA_CATEGORY, R.string.tvshow)
                    startActivity(intent)
                }
            })

            with(rv_tvshow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvshowAdapter
            }
        }
    }
}