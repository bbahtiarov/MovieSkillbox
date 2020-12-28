package com.example.movieslillbox.presentation.favorites.recyclerVIew

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

class FavoriteAdapter (private var favoriteList: List<Movie>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteHolder(view)
    }

    override fun getItemCount(): Int = favoriteList.size

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.bindData(favoriteList, position)
    }

    class FavoriteHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.title_favorite_textView)
        private val overview: TextView = itemView.findViewById(R.id.overview_favorite_textView)
        private val poster: ImageView = itemView.findViewById(R.id.favorite_imageView)

        fun bindData(list: List<Movie>, position: Int) {
            val moviePosterURL = POSTER_BASE_URL + list[position].posterPath
            title.text = list[position].title
            overview.text = list[position].overview
            poster.downloadAndSetImage(moviePosterURL)
        }
    }
}