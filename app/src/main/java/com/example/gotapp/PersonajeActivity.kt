package com.example.gotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gotapp.R
import com.example.gotapp.databinding.ActivityLoginBinding
import com.example.gotapp.databinding.ActivityPersonajeBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PersonajeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonajeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://anapioficeandfire.com/api/characters/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}