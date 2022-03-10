package com.example.foodcookbook.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.foodcookbook.databinding.ActivityLoginBinding
import com.example.foodcookbook.models.AccessResultModel
import com.example.foodcookbook.viewmodel.RecipeBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    var binding:ActivityLoginBinding? = null
    private val viewModelUserAccess: RecipeBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.tvRegistro?.setOnClickListener {
            startActivityRegistroUsu()
        }

        binding?.btnEnter?.setOnClickListener {
            validUser(binding?.edUserName?.text.toString(), binding?.edPassword?.text.toString(), "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        }

        binding?.tvSalir?.setOnClickListener {
            finish()
        }

        initLoginObserver()

    }
    //Callback
    private val useraccessResult = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {
            startActivityItemRecipebook()
        }else{
            Toast.makeText(this,"the username or password is invalid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initLoginObserver() {
        viewModelUserAccess.userAccessResult.observe(this, useraccessResult)
    }

    fun validUser(user:String, pwd:String,userId:String)
    {
        viewModelUserAccess.userValidation(user,pwd,userId)
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