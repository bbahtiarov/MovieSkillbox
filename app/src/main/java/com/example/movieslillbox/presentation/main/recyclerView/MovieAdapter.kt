package com.example.movieslillbox.presentation.main.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslillbox.R
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.presentation.detail.DetailMovieFragment
import com.example.movieslillbox.utils.POSTER_BASE_URL
import com.example.movieslillbox.utils.downloadAndSetImage
import com.example.movieslillbox.utils.replaceToFragment


class MovieAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_fragment_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bindData(movieList, position)
    }

    class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.title_textView)
        private val voteAvg: TextView = itemView.findViewById(R.id.vote_average_textView)
        private val poster: ImageView = itemView.findViewById(R.id.poster_imageView)

        fun bindData(list: List<Movie>, position: Int) {
            val moviePosterURL = POSTER_BASE_URL + list[position].posterPath
            title.text = list[position].title
            voteAvg.text = list[position].voteAverage
            poster.downloadAndSetImage(moviePosterURL)
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("title", list[position].title)
                bundle.putString("releaseDate", list[position].releaseDate)
                bundle.putString("originalLanguage", list[position].originalLanguage)
                bundle.putString("overview", list[position].overview)
                bundle.putString("voteAverage", list[position].voteAverage)
                bundle.putString("poster", moviePosterURL)
                val detailMovieFragment = DetailMovieFragment()
                detailMovieFragment.arguments = bundle

                replaceToFragment(detailMovieFragment)
            }
        }
    }
}


