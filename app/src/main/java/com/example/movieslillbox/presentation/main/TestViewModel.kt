package com.example.movieslillbox.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.data.room.MovieRoomRepository
import com.example.movieslillbox.utils.APP_ACTIVITY

class TestViewModel : ViewModel() {

    var movieListData: LiveData<MutableList<Movie?>>? = MutableLiveData()
    var movieRoomRepository: MovieRoomRepository? = null

    init {
        movieRoomRepository = MovieRoomRepository(APP_ACTIVITY.application)
        //movieListData = movieRoomRepository!!.savedData
    }

    suspend fun fetchFromWeb() {
        movieRoomRepository?.getAllData()
    }

    suspend fun updateData(locationData: Movie?) {
        locationData?.let { movieRoomRepository?.updateData(it) }
    }

}