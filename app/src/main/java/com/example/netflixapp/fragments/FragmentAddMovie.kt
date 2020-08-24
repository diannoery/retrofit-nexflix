package com.example.netflixapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.netflixapp.R
import com.example.netflixapp.netflix.Movie
import com.example.netflixapp.viewmodel.ViewModelMovie
import kotlinx.android.synthetic.main.fragment_add_movie.*


class FragmentAddMovie : Fragment(),View.OnClickListener {
    val viewModelMovie by activityViewModels<ViewModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveMovie.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v){
           saveMovie->{
                val movieAdd= Movie(
                    title = TitleMovie.text.toString(),
                    duration = durationMovie.text.toString(),
                    image = ImageUrl.text.toString(),
                    synopsis =  synopsis.text.toString()
                )
                viewModelMovie.saveFilm(movieAdd)
               activity?.onBackPressed()
           }
       }
    }


}