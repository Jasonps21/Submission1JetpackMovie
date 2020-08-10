package com.jason.movietvcatalog.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jason.movietvcatalog.vo.Status
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.viewModel.ViewModelFactory
import com.jason.movietvcatalog.`interface`.OnItemClickCallback
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.ui.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.fragment_tvshow.*
import kotlinx.android.synthetic.main.fragment_tvshow.progress_bar

class TvShowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvshowAdapter = TvShowAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getTvshow().observe(viewLifecycleOwner, Observer{ tvShows ->
                if (tvShows != null){
                    when(tvShows.status){
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar.visibility = View.GONE
                            tvshowAdapter.submitList(tvShows.data)
                            tvshowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
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
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = tvshowAdapter
            }
        }
    }
}