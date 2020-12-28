package com.example.movieslillbox.data.api

import com.example.movieslillbox.data.models.MovieResponse
import com.example.movieslillbox.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRetrofitService {
    @GET("movie/popular")
    suspend fun getPopularMovie(@Query("api_key") apiKey:String = API_KEY) : Response<MovieResponse>

   /* @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") id: Int): Response<DetailMovie>*/
}