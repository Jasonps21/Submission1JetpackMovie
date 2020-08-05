package com.jason.movietvcatalog.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.`interface`.OnItemClickCallback
import com.jason.movietvcatalog.data.source.local.entity.MovieEntity
import com.jason.movietvcatalog.data.source.remote.ApiClient
import kotlinx.android.synthetic.main.items_movie.view.*

class TvshowAdapter: RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    private var listTvshow = ArrayList<MovieEntity>()

    fun setTvshow(courses: List<MovieEntity>?) {
        if (courses == null) return
        listTvshow.clear()
        listTvshow.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return TvshowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = listTvshow[position]
        holder.bind(tvshow)
    }

    override fun getItemCount(): Int = listTvshow.size

    inner class TvshowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvshow: MovieEntity) {
            with(itemView) {
                Glide.with(context)
                    .load(ApiClient.BASE_URL_IMAGE + tvshow.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(img_poster)
                setOnClickListener { onItemClickCallback?.onItemClicked(tvshow) }
            }
        }
    }
}