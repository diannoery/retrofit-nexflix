package com.example.netflixapp.netflix

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieAPI {
    @GET("film")
    fun getAllFilm(): Call<List<Movie>>


    @GET("film/{id}")
    fun getFilmById(@Path("id")id: String): Call<Movie>

    @POST("film")
    fun createFilm(@Body movie: Movie): Call<Movie>
}