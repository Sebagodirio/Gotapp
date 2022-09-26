package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonajesActivity extends AppCompatActivity {

    private RecyclerView rvPersonajes;
    PersonajeAdapter adapter;
    private Toolbar mainToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.volver) {
            Intent intent = new Intent(PersonajesActivity.this, HomePage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);
        setUpAdapter();
        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Game of Thrones");
    }

    private void setUpAdapter() {
        rvPersonajes = findViewById(R.id.rv_personajes);
        adapter = new PersonajeAdapter(getPersonajes());
        rvPersonajes.setAdapter(adapter);
    }

    private List<Personaje> getPersonajes() {
        return new ArrayList<Personaje>(){{
                add(new Personaje(1, null, "Jhon", "Masculino", "10/5/1990", "yankee"));
                add(new Personaje(2, null, "Smith", "Masculino", "10/5/1991", "yankee"));
                add(new Personaje(3, null, "Simon", "Masculino", "10/5/1992", "yankee"));
                add(new Personaje(4, null, "Jessica", "Femenino", "10/5/1996", "yankee"));
                add(new Personaje(5, null, "Emily", "Femenino", "10/5/1994", "yankee"));
            }};
    }
}