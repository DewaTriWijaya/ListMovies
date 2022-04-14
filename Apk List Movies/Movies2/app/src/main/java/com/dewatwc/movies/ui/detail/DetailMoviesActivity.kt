package com.dewatwc.movies.ui.detail


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dewatwc.movies.R
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.viewmodel.ViewModelFactory
import com.dewatwc.movies.vo.Status
import kotlinx.android.synthetic.main.activity_detail_movies.*
import kotlinx.android.synthetic.main.content_detail_movies.*



class DetailMoviesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var viewModel: DetailMoviesViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movies)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailMoviesAdapter()

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMoviesViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_COURSE)
            if (moviesId != null) {
                viewModel.setSelectedMovies(moviesId)

                viewModel.moviesModule.observe(this, Observer { MoviesWithPlayerResource ->
                    if (MoviesWithPlayerResource != null) {
                        when (MoviesWithPlayerResource.status) {
                            Status.LOADING -> progress_bar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (MoviesWithPlayerResource.data != null) {
                                progress_bar.visibility = View.GONE
                                adapter.setPlayer(MoviesWithPlayerResource.data.mPlayer)
                                adapter.notifyDataSetChanged()
                                populateCourse(MoviesWithPlayerResource.data.mMovies)
                            }
                            Status.ERROR -> {
                                progress_bar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }

                    }
                })
            }
        }

        rv_player.isNestedScrollingEnabled = false
        rv_player.layoutManager = LinearLayoutManager(this)
        rv_player.setHasFixedSize(true)
        rv_player.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(rv_player.context, DividerItemDecoration.VERTICAL)
        rv_player.addItemDecoration(dividerItemDecoration)
    }

    private fun populateCourse(datamovies: DataMovies) {
        text_title.text = datamovies.title
        text_desc.text = datamovies.description
        text_date.text = resources.getString(R.string.broadcast_date, datamovies.broadcast)

        Glide.with(this)
                .load(datamovies.imagePath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(image_poster)



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        this.menu = menu
        viewModel.moviesModule.observe(this, Observer{ moviesWithPlayer ->
            if (moviesWithPlayer != null) {
                when (moviesWithPlayer.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (moviesWithPlayer.data != null) {
                        progress_bar.visibility = View.GONE
                        val state = moviesWithPlayer.data.mMovies.tvShow
                        setTvShowState(state)
                    }
                    Status.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_tvshow) {
            viewModel.setTvShow()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setTvShowState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_tvshow)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_tvshow_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_tvshoww_white)
        }
    }
}


