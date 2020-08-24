package com.example.netflixapp.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netflixapp.config.RetrofitBuilder
import com.example.netflixapp.netflix.Movie
import com.example.netflixapp.netflix.MovieAPI
import com.example.netflixapp.netflix.MovieRepository

class ViewModelMovie : ViewModel() {
    val movieRepository: MovieRepository

    init {
        val movieAPI = RetrofitBuilder.createRetrofit().create(MovieAPI::class.java)
        movieRepository = MovieRepository(movieAPI)
    }

    val movie: LiveData<List<Movie>> = movieRepository.movieList

    fun getAllFilm(){
        movieRepository.getAllFilm()
    }

//    fun getFilmById(id: String){
//        movieRepository.getFilmById(id)
//    }

    fun saveFilm(movie: Movie){
        movieRepository.saveFilm(movie)
    }

    //    val musicList = mutableListOf<MovieList>(
//        MovieList(
//            "Bara Suara",
//            "Sendu Melagu",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "asusaus"
//        ),
//        MovieList(
//            "Terminator 2: Judgment Day 3D",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        ),
//        MovieList(
//            "Dunkirk",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        ),
//        MovieList(
//            "The Salesman",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        ),
//        MovieList(
//            "Terminator 2: Judgment Day 3D",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        ),
//        MovieList(
//            "Terminator 2: Judgment Day 3D",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        ),MovieList(
//            "Terminator 2: Judgment Day 3D",
//            "1:10:30",
//            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG",
//            "skfaskfalf"
//        )
//    )
//
//    val movieLiveData: MutableLiveData<MutableList<MovieList>> = MutableLiveData(musicList)


}

class MovieList(title: String, duration: String, image: String, synopsis: String) {
    var title = title
    var duration = duration
    var imageUrl = image
    var synopsis = synopsis
}