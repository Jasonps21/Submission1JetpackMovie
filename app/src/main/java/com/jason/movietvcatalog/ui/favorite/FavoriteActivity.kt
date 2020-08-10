package com.jason.movietvcatalog.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jason.movietvcatalog.R
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        val sectionsPagerAdapter = SectionsPagerAdapterFavorite(this, supportFragmentManager)
        view_pager_favorite.adapter = sectionsPagerAdapter
        tabs_favorite.setupWithViewPager(view_pager_favorite)
        supportActionBar?.elevation = 0f
    }
}