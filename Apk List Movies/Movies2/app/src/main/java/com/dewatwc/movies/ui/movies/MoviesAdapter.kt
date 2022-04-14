package com.dewatwc.movies.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dewatwc.movies.R
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.ui.detail.DetailMoviesActivity
import kotlinx.android.synthetic.main.items_movies.view.*


class MoviesAdapter internal constructor() : PagedListAdapter<DataMovies, MoviesAdapter.MoviesViewHolder>(
    DIFF_CALLBACK
) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataMovies>() {
            override fun areItemsTheSame(oldItem: DataMovies, newItem: DataMovies): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: DataMovies, newItem: DataMovies): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }
    

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: DataMovies) {
            with(itemView) {
                tv_item_title.text = movies.title
                tv_item_description.text = movies.description
                tv_item_date.text = itemView.resources.getString(R.string.broadcast_date, movies.broadcast)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_COURSE, movies.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(context)
                        .load(movies.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(img_poster)
            }
        }
    }
}

