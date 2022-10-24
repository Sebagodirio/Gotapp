package com.example.gotapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GotApi {
    @GET("/characters")
   suspend fun getCharacters() : Response<List<PersonajesResponse>>


}