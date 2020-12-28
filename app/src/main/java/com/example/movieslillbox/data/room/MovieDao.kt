package com.example.movieslillbox.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieslillbox.data.models.Movie


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(listMovie: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovie(movie: Movie)

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(favMovie: Movie)

    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    fun getAllSavedData(): LiveData<List<Movie>>

    @Query("SELECT EXISTS (SELECT 1 FROM movie_table WHERE id=:id)")
    fun isFavorite(id: Int): Int
}