package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button personajesBtn;
    private Toolbar mainToolbar;

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.volver) {
            Intent intent = new Intent(HomePage.this, HomePage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }*/ //Tenerlo en el Main no me parece conveniente, asi que lo puse en las paginas que lo usemos


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