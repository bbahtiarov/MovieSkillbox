package com.example.movieslillbox.utils

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.movieslillbox.R

fun ImageView.downloadAndSetImage(url: String) {
    Glide
        .with(APP_ACTIVITY)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.placeholder)
        .into(this)
}

fun replaceToFragment(fragment: Fragment) {
    APP_ACTIVITY.supportFragmentManager.beginTransaction()
        .replace(R.id.container_fragment, fragment)
        .addToBackStack(null)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        .commit()
}