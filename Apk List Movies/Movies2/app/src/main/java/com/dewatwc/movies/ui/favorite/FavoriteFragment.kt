package com.dewatwc.movies.ui.favorite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dewatwc.movies.R
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment(), FavoriteFragmentCallback {

    lateinit var viewModel: FavoriteViewModel
    lateinit var adapter: FavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            adapter = FavoriteAdapter(this)
            progress_bar.visibility = View.VISIBLE
            viewModel.getFavorite().observe(this, Observer { favorite ->
                progress_bar.visibility = View.GONE
                adapter.submitList(favorite)
                adapter.notifyDataSetChanged()
            })

            rv_favorite.layoutManager = LinearLayoutManager(context)
            rv_favorite.setHasFixedSize(true)
            rv_favorite.adapter = adapter
        }
    }

    override fun onShareClick(favorite: DataMovies) {
        if (activity != null) {
            val mimeType = "text/plain"
            this.activity?.let {
                ShareCompat.IntentBuilder
                    .from(it)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText("Segeralah Tonton film ${favorite.title} di Movies Studio atau di www.netflix.com")
                    .startChooser()
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
                makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val favorite = adapter.getSwipedData(swipedPosition)
                favorite?.let { viewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    favorite?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}

