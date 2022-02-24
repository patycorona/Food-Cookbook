package com.example.foodcookbook.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.foodcookbook.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    var binding:ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val tv_registro = binding?.tvRegistro as TextView
        val btn_enter = binding?.btnEnter as Button
        val btn_salir = binding?.tvSalir as TextView

        tv_registro.setOnClickListener {
            startActivityRegistroUsu()
        }

        btn_enter.setOnClickListener {
            startActivityItemRecipebook()
        }
        btn_salir.setOnClickListener {
            finish()
        }

    }

    fun startActivityRegistroUsu() {
        startActivity(Intent(this, RegistroUsuario::class.java))
        finish()
    }

    fun startActivityItemRecipebook() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}