package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPassword;
    private EditText etPasswordRepetida;
    private Button registrarseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        etUsuario = findViewById(R.id.etr_usuario);
        etPassword = findViewById(R.id.etr_password);
        etPasswordRepetida = findViewById(R.id.etr_password_repetida);

        String usuario = etUsuario.getText().toString();
        String password = etPassword.getText().toString();

        registrarseBtn = findViewById(R.id.btn_registrarse_form);
        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    registrar(usuario, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(RegistrarseActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registrar(String usuario, String password) throws Exception {
        Login login = new Login( usuario, password);
        try {
            LoginManager.getInstancia(this).agregarLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}