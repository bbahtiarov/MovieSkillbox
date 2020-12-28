package com.example.movieslillbox.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieslillbox.data.models.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var database:MovieDb? = null

        @Synchronized
        fun getDatabase(context: Context): MovieDb {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    MovieDb::class.java,
                    "database"
                ).build()
                database as MovieDb
            } else database as MovieDb
        }
    }

}