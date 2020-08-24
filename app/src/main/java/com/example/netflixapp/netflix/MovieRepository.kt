package com.example.netflixapp.netflix

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val movieAPI: MovieAPI) {
    var movie: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    var movieList:MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    fun getAllFilm() {
        movieAPI.getAllFilm().enqueue(object :  Callback<List<Movie>> {
            override fun onResponse(
                call: Call<List<Movie>>,
                response: Response<List<Movie>>
            ) {

                val response = response.body()
                println("movie repostory"+response)
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val movieObject:List<Movie> = gson.fromJson(stringResponse,Array<Movie>::class.java).toList()
                movieList.value = movieObject
                println(movieObject)
                            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                println("Failed Because ${t.printStackTrace()}")
                println("Failed Because ${t.localizedMessage}")            }

        })
    }

//    fun getFilmById(id: String) {
//        movieAPI.getFilmById(id).enqueue(object : Callback<WrapperResponse> {
//            override fun onResponse(
//                call: Call<WrapperResponse>,
//                response: Response<WrapperResponse>
//            ) {
//                if (response.code() == 200) {
//                    val response = response.body()
//                    val gson = Gson()
//                    val result = gson.toJson(response?.result)
//                    val filmObject = gson.fromJson<Movie>(result, Movie::class.java)
//                    movie.value = listOf(filmObject)
//                }
//            }
//
//            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
//                println("Failed Because ${t.printStackTrace()}")
//                println("Failed Because ${t.localizedMessage}")
//            }
//        }
//        )
//    }

    fun saveFilm(movie: Movie) {
        movieAPI.createFilm(movie).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
                println("Failed Created Film Because  ${t.localizedMessage}")
            }

        })
    }
}