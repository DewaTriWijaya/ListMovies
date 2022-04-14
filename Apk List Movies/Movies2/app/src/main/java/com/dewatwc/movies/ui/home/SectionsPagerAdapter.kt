package com.dewatwc.movies.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dewatwc.movies.R
import com.dewatwc.movies.ui.favorite.FavoriteFragment
import com.dewatwc.movies.ui.movies.MoviesFragment
import com.dewatwc.movies.ui.tvshow.TvShowFragment


class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(R.string.home, R.string.tvshow, R.string.favorite)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> MoviesFragment()
                1 -> TvShowFragment()
                2 -> FavoriteFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}