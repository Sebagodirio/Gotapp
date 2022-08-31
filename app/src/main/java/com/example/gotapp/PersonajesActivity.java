package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PersonajesActivity extends AppCompatActivity {

    private LinearLayout clickExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        clickExample = findViewById(R.id.example_layout);
        clickExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonajesActivity.this, PersonajeActivity.class);
                startActivity(intent);
            }
        });
    }
}