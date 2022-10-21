package com.example.gotapp

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gotapp.PersonajeAdapter
import com.example.gotapp.R
import android.content.Intent
import com.example.gotapp.HomePage
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.gotapp.Personaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class PersonajesActivity : AppCompatActivity() {
    private lateinit var rvPersonajes: RecyclerView
    var adapter: PersonajeAdapter? = null
    private var mainToolbar: Toolbar? = null
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.volver) {
            val intent = Intent(this@PersonajesActivity, HomePage::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personajes)
        setUpAdapter()
        mainToolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(mainToolbar)
        supportActionBar!!.title = "Game of Thrones"
    }

    private fun setUpAdapter() {
        rvPersonajes = findViewById(R.id.rv_personajes)
        adapter = PersonajeAdapter(personajes)
        rvPersonajes.setAdapter(adapter)
    }


    private fun personajesGet(): ArrayList<Personaje?> {
        val api = RetrofitClient.retrofit.create(GotApi::class.java)
        val callGetCharacter =api.getCharacters()


        callGetCharacter.enqueue(object : retrofit2.Callback<List<Personaje>> {
            override fun onResponse(
                call: Call<List<Personaje>>,
                response: Response<List<Personaje>>
            ) {
                val personajesres = response?.body()

                if (personajesres != null) {
                    for (personaje in personajesres) {
                        personajes.add(
                            Personaje(
                                personaje.id,
                                personaje.imagen,
                                personaje.nombre,
                                personaje.genero,
                                personaje.nacimiento,
                                personaje.cultura
                            )
                        )
                    }
                }

            }



            override fun onFailure(call: Call<List<Personaje>>, t: Throwable) {
                Log.e("Error", t.message ?:" ")
                t?.printStackTrace()
            }

        })
        return personajes
    }



    private val personajes: ArrayList<Personaje?> = personajesGet()
}