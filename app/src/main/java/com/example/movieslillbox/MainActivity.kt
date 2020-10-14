package com.example.movieslillbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieslillbox.presentation.main.MainFragment
import com.example.movieslillbox.utils.APP_ACTIVITY


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        APP_ACTIVITY = this
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, MainFragment.newInstance())
                .commitNow()
        }
    }
}