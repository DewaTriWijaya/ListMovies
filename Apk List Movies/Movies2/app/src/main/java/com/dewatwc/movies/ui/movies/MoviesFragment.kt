package com.dewatwc.movies.ui.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dewatwc.movies.R
import com.dewatwc.movies.viewmodel.ViewModelFactory
import com.dewatwc.movies.vo.Status
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val mAdapter = MoviesAdapter()
            viewModel.getMovies().observe(this, Observer { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar.visibility = View.GONE
                            mAdapter.submitList(movies.data)
                            mAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(rv_movies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mAdapter
            }
        }
    }
}

