package com.example.movieslillbox.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieslillbox.R
import com.example.movieslillbox.utils.downloadAndSetImage
import kotlinx.android.synthetic.main.detail_movie_fragment.*

class DetailMovieFragment : Fragment(R.layout.detail_movie_fragment) {

    companion object {
        fun newInstance() = DetailMovieFragment()
    }

    private lateinit var viewModel: DetailMovieViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)

        val bundle = this.arguments
        movie_title_textView.text = bundle?.getString("title")
        release_date_textView.text = bundle?.getString("releaseDate")
        vote_average_textView.text = bundle?.getString("voteAverage")
        original_language_text_view.text = bundle?.getString("originalLanguage")
        overview_textView.text = bundle?.getString("overview")

        val posterUrl = bundle?.getString("poster")
        movie_poster_imageView.downloadAndSetImage(posterUrl.toString())
    }
}