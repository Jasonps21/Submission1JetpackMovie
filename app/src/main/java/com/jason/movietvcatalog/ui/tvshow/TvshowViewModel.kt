package com.jason.movietvcatalog.ui.tvshow

import androidx.lifecycle.ViewModel
import com.jason.movietvcatalog.data.MovieEntity
import com.jason.movietvcatalog.utils.DataDummy

class TvshowViewModel: ViewModel() {
    fun getTvshow(): List<MovieEntity> = DataDummy.generateDummyTVShow()
}