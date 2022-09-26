package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private Button personajesBtn;
    private Toolbar mainToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.volver) {
            Intent intent = new Intent(HomePage.this, LoginActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.logout) {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(Constantes.USUARIO, null);
            editor.putString(Constantes.PASSWORD, null);
            editor.apply();
            Toast.makeText(HomePage.this, "Usuario deslogueado con exito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Game of Thrones");
        personajesBtn = findViewById(R.id.btn_personajes);
        personajesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, PersonajesActivity.class);
                startActivity(intent);
            }
        });
    }
}