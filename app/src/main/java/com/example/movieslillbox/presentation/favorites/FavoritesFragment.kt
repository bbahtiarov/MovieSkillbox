package com.example.movieslillbox.presentation.favorites

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieslillbox.R
import com.example.movieslillbox.presentation.favorites.recyclerVIew.FavoriteAdapter
import com.example.movieslillbox.presentation.main.recyclerView.GridAutofitLayoutManager
import com.example.movieslillbox.presentation.main.recyclerView.MovieAdapter
import com.example.movieslillbox.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.favorites_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*

class FavoritesFragment : Fragment(R.layout.favorites_fragment) {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    private lateinit var viewModel: FavoritesViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerList = favorite_recyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(APP_ACTIVITY)
        }
        viewModel.movieListData.observe(viewLifecycleOwner, Observer {
            recyclerList.adapter = FavoriteAdapter(it)
        })
    }

}