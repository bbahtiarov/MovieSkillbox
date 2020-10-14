package com.example.movieslillbox.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieslillbox.R

class DetailMovieFragment : Fragment(R.layout.detail_movie_fragment) {

    companion object {
        fun newInstance() = DetailMovieFragment()
    }

    private lateinit var viewModel: DetailMovieViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
    }

}