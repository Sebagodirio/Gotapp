package com.example.gotapp

import retrofit2.Call
import retrofit2.http.GET

interface GotApi {
    @GET("/characters")
    fun getCharacters() : Call<List<Personaje>>


}