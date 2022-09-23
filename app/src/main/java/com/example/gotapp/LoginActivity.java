package com.example.gotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private CheckBox cbRecordarUsuario;
    private Toolbar mainToolbar;
    private EditText etUsuario;
    private EditText etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.et_usuario);
        etPass = findViewById(R.id.et_pass);

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Game of Thrones");

        cbRecordarUsuario = findViewById(R.id.cb_recordar_usuario);
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = prefs.getString(Constantes.USUARIO, null);
        String passGuardada = prefs.getString(Constantes.PASSWORD, null);
        
        if(usuarioGuardado != null && passGuardada != null){
            irAHomePage();
        }
        

        loginBtn = findViewById(R.id.btn_login_form);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String password = etPass.getText().toString();

                if(usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        login(usuario, password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void login(String usuario, String password) throws Exception {
        if(cbRecordarUsuario.isChecked()) {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(Constantes.USUARIO, usuario);
            editor.putString(Constantes.PASSWORD, password);
            editor.apply();
        }
        try {
            List<Login> loginList= LoginManager.getInstancia(this).getLogin(usuario, password);
            Boolean existe = false;
            for (int i = 0; i < loginList.size(); i++) {
                if(Objects.equals(loginList.get(i).getUsuario(), usuario) && Objects.equals(loginList.get(i).getPassword(), password)) {
                    existe = true;
                    irAHomePage();
                    finish();
                }
            }
            if(!existe) {
                Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException | java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    private void irAHomePage() {
        Intent intent = new Intent(LoginActivity.this, HomePage.class);
        startActivity(intent);
    }
}