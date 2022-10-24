package com.example.gotapp

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gotapp.databinding.ActivityPersonajesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.ArrayList

class PersonajesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonajesBinding
    private lateinit var rvPersonajes: RecyclerView
    var adapter: PersonajeAdapter? = null
    private var mainToolbar: Toolbar? = null

    private val personajesImagenes = mutableListOf<String>()

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
        initRecyclerView()
    }

    private fun initRecyclerView(){
        adapter = PersonajeAdapter(personajesImagenes)
        binding.rvPersonajes.layoutManager = LinearLayoutManager(this)
        binding.rvPersonajes.adapter = adapter


    }

  /*  private fun setUpAdapter() {
        rvPersonajes = findViewById(R.id.rv_personajes)
        adapter = PersonajeAdapter(personajes)
        rvPersonajes.setAdapter(adapter)
    }*/


    private fun personajesGet(){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<List<PersonajesResponse>> = RetrofitClient.retrofit.create(GotApi::class.java).getCharacters()
            val characters: List<PersonajesResponse>? =  call.body()
            var aux: PersonajesResponse ?=null
            if (characters != null) {
                for(s in characters){
                    aux = s
                }
            }
            runOnUiThread{
                if(call.isSuccessful){
                    //TODO
                    Log.i("Characters", characters.toString())
                    val images : String? = aux?.url


                }else{
                    Log.i("Error","Error")

                }
            }



        }

    }



    private val personajes: ArrayList<Personaje?>
        get() {
            TODO()
        }
}