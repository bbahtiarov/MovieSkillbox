package com.example.movieslillbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.movieslillbox.presentation.favorites.FavoritesFragment
import com.example.movieslillbox.presentation.main.MainFragment
import com.example.movieslillbox.presentation.profile.ProfileFragment
import com.example.movieslillbox.utils.APP_ACTIVITY
import com.example.movieslillbox.utils.replaceToFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        APP_ACTIVITY = this

        val bottomNav = bottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, MainFragment.newInstance())
                .commitNow()
        }
    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.menu_item -> selectedFragment = MainFragment()
                R.id.favourite_item -> selectedFragment = FavoritesFragment()
                R.id.profile_item -> selectedFragment = ProfileFragment()
            }
            if (selectedFragment != null) {
                replaceToFragment(selectedFragment)
            }
            true
        }
}