package com.example.movieslillbox.presentation.main.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieslillbox.R
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.presentation.detail.DetailMovieFragment
import com.example.movieslillbox.utils.APP_ACTIVITY
import com.example.movieslillbox.utils.POSTER_BASE_URL


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

        //    private val detailPoster:ImageView = itemView.findViewById(R.id.movie_poster_imageView)
       /* private val rating:TextView = itemView.findViewById(R.id.rating_textView)
        private val runtime:TextView = itemView.findViewById(R.id.runtime_textView)
        private val overview:TextView = itemView.findViewById(R.id.overview_textView)*/


        fun bindData(list: List<Movie>, position: Int) {
            val moviePosterURL = POSTER_BASE_URL + list[position].posterPath
            title.text = list[position].title
            voteAvg.text = list[position].voteAverage
            /*rating.text = list[position].rating.toString()
            runtime.text = list[position].runtime.toString()
            overview.text = list[position].overview*/
            poster.downloadAndSetImage(moviePosterURL)
            itemView.setOnClickListener {
                click()

            }
        }


        private fun click() {
            APP_ACTIVITY.supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, DetailMovieFragment.newInstance())
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }

        private fun ImageView.downloadAndSetImage(url: String) {
            Glide
                .with(APP_ACTIVITY)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(this)
        }
    }
}

