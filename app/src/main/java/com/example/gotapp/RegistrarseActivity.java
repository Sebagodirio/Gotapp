package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPassword;
    private EditText etPasswordRepetida;
    private Button registrarseBtn;
    private Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Game of Thrones");

        etUsuario = findViewById(R.id.etr_usuario);
        etPassword = findViewById(R.id.etr_password);
        etPasswordRepetida = findViewById(R.id.etr_password_repetida);

        registrarseBtn = findViewById(R.id.btn_registrarse_form);
        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login login = new Login();
                login.setUsuario(etUsuario.getText().toString());
                login.setPassword(etPassword.getText().toString());
                try {
                    LoginManager.getInstancia(RegistrarseActivity.this).agregarLogin(login);
                    etUsuario.setText("");
                    etPassword.setText("");
                    Toast.makeText(RegistrarseActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(RegistrarseActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}