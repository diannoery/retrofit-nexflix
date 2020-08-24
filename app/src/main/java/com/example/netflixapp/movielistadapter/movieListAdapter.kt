package com.example.netflixapp.movielistadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.netflixapp.R
import com.example.netflixapp.netflix.Movie
import com.example.netflixapp.viewmodel.MovieList
import com.example.netflixapp.viewmodel.ViewModelMovie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_layout.view.*

class MovieRecycleAdapter (private val listMovie: List<Movie>,val viewModelMovie: ViewModelMovie): RecyclerView.Adapter<MovieViewHolder>(){
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_layout, parent, false)
        context = parent.context
        return MovieViewHolder(view, viewModelMovie)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.index = position.toString()
        holder.itemView.setOnClickListener(holder)
        var imageName = listMovie[position].image
        Glide.with(context).load(imageName).into(holder.imageFilm)
    }

}

class MovieViewHolder(v: View, val viewModelMovie: ViewModelMovie) : RecyclerView.ViewHolder(v), View.OnClickListener {
    var index: String = ""
    var imageFilm: ImageView = v.findViewById(R.id.movieImage)

    override fun onClick(v: View?) {
        when(v) {
            itemView -> {
                //viewModelMovie.getFilmById(index)
                Toast.makeText(v.context, " your click", Toast.LENGTH_SHORT).show()
                //itemView.findNavController().navigate(R.id.action_filmFragment_to_detailFilmFragment)
            }

        }
    }
}