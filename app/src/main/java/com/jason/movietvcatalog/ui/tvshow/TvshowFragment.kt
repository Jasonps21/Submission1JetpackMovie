package com.jason.movietvcatalog.ui.tvshow

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
import com.jason.movietvcatalog.data.MovieEntity
import com.jason.movietvcatalog.ui.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.fragment_tvshow.*

class TvshowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvshowViewModel::class.java]
            val tvshow = viewModel.getTvshow()
            val tvshowAdapter = TvshowAdapter()
            tvshowAdapter.setTvshow(tvshow)

            tvshowAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: MovieEntity) {
                    val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                    intent.putExtra(DetailMovieActivity.EXTRA_CATEGORY, R.string.tvshow)
                    startActivity(intent)
                }
            })

            with(rv_tvshow) {
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = tvshowAdapter
            }
        }
    }
}