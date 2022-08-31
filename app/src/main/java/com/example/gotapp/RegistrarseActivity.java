package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrarseActivity extends AppCompatActivity {

    private Button registrarseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        registrarseBtn = findViewById(R.id.btn_registrarse_form);
        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarseActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}