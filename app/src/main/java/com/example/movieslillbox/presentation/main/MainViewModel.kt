package com.example.movieslillbox.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieslillbox.data.api.MovieRetrofitService
import com.example.movieslillbox.data.models.Movie
import com.example.movieslillbox.utils.BASE_URL
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val movieListData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        val api = retrofit.create(MovieRetrofitService::class.java)

        viewModelScope.launch {
            val result = api.getPopularMovie()
            result.body()?.movies.let {
                movieListData.postValue(it)
            }
        }
    }

}