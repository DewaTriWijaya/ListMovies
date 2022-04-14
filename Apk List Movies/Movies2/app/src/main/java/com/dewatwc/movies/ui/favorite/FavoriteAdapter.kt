package com.dewatwc.movies.ui.favorite

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
import kotlinx.android.synthetic.main.items_tv_show.view.*


class FavoriteAdapter(private val callback: FavoriteFragmentCallback) : PagedListAdapter<DataMovies, FavoriteAdapter.FavoriteViewHolder>(
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv_show, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = getItem(position)
        if (favorite != null) {
            holder.bind(favorite)
        }
    }

    fun getSwipedData(swipedPosition: Int): DataMovies? = getItem(swipedPosition)



    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favorite: DataMovies){
            with(itemView){
                tv_item_title.text = favorite.title
                tv_item_description.text = favorite.description
                tv_item_date.text = itemView.resources.getString(R.string.broadcast_date, favorite.broadcast)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_COURSE, favorite.movieId)
                    itemView.context.startActivity(intent)
                }
                img_share.setOnClickListener { callback.onShareClick(favorite) }
                Glide.with(context)
                        .load(favorite.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(img_poster)
            }
        }
    }
}

