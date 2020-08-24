package com.example.netflixapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.netflixapp.R
import com.example.netflixapp.movielistadapter.MovieRecycleAdapter
import com.example.netflixapp.viewmodel.ViewModelMovie
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {
    val viewModelMovie by activityViewModels<ViewModelMovie>()
    lateinit var movieViewRecycleAdapter: MovieRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val grid = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        movieRecycle.layoutManager=LinearLayoutManager(activity)
        //viewModelMovie.getAllMovie()
        viewModelMovie.movie.observe(viewLifecycleOwner, Observer {
            movieViewRecycleAdapter = MovieRecycleAdapter(it,viewModelMovie)
            movieRecycle.adapter = movieViewRecycleAdapter
            movieViewRecycleAdapter.notifyDataSetChanged()
        })
        viewModelMovie.getAllFilm()
    }
}