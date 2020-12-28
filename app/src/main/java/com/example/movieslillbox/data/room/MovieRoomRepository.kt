package com.example.movieslillbox.data.room

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.movieslillbox.data.api.MovieClient
import com.example.movieslillbox.data.api.MovieRetrofitService
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.data.models.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRoomRepository(application: Application) {
    private val instance: MovieRoomRepository? = null
    private var apiInterface: MovieRetrofitService? = null
    var savedData: LiveData<MutableList<Movie>>? = null
    private var movieDao: MovieDao? = null
    private var mContext: Context? = null

    init {
        apiInterface = MovieClient.getInstance()?.create(MovieRetrofitService::class.java)
        val db: MovieDb = MovieDb.getDatabase(application)
        movieDao = db.movieDao()
        //savedData = movieDao!!.getAllSavedData()
        mContext = application.applicationContext
    }

    suspend fun getAllData() {
        val call = apiInterface?.getPopularMovie()
        insertData(call?.body()?.movies)
    }

    private suspend fun insertData(movieList: List<Movie>?) {
        CoroutineScope(Dispatchers.IO).launch {
            movieList?.let { movieDao?.insert(it) }
        }
    }

    suspend fun updateData(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            movie.let { movieDao?.update(it) }
        }
    }

}