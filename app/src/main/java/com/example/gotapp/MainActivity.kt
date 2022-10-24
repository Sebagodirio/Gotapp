package com.example.gotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gotapp.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.gotapp.LoginActivity
import com.example.gotapp.RegistrarseActivity
import com.example.gotapp.databinding.ActivityLoginBinding
import com.example.gotapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var btnLogin: Button
    private lateinit var btnRegistrarse: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnLogin = findViewById(R.id.btn_login)
        btnRegistrarse = findViewById(R.id.btn_registrarse)
        btnLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        })
        btnRegistrarse.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RegistrarseActivity::class.java)
            startActivity(intent)
        })
    }
}