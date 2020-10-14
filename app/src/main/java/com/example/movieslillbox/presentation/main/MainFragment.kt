package com.example.movieslillbox.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieslillbox.R
import com.example.movieslillbox.presentation.main.recyclerView.GridAutofitLayoutManager
import com.example.movieslillbox.presentation.main.recyclerView.MovieAdapter
import com.example.movieslillbox.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val columnWidth = APP_ACTIVITY.resources.getDimension(R.dimen.poster_width).toInt()
        val recyclerList = main_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager =
                GridAutofitLayoutManager(
                    APP_ACTIVITY,
                    columnWidth
                )
        }
        viewModel.movieListData.observe(viewLifecycleOwner, Observer {
            recyclerList?.adapter = MovieAdapter(it)
        })
    }

}