package com.example.movieslillbox.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieslillbox.R
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.data.room.MovieDb
import com.example.movieslillbox.utils.APP_ACTIVITY
import com.example.movieslillbox.utils.downloadAndSetImage
import kotlinx.android.synthetic.main.detail_movie_fragment.*

class DetailMovieFragment : Fragment(R.layout.detail_movie_fragment) {

    // for second branch

    companion object {
        fun newInstance() = DetailMovieFragment()
    }

    private lateinit var viewModel: DetailMovieViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
        val bundle = this.arguments
        val movie: Movie = bundle?.getSerializable("data") as Movie
        movie_title_textView.text = movie.title
        release_date_textView.text = movie.releaseDate
        vote_average_textView.text = movie.voteAverage
        original_language_text_view.text = movie.originalLanguage
        overview_textView.text = movie.overview

        val posterUrl = bundle.getString("poster")
        movie_poster_imageView.downloadAndSetImage(posterUrl.toString())
    }
}