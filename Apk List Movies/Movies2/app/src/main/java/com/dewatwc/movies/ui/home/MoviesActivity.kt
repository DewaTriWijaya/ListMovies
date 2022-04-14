package com.dewatwc.movies.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dewatwc.movies.R
import kotlinx.android.synthetic.main.activity_movies.*


class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f

    }
}