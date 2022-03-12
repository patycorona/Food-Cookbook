package com.example.foodcookbook.views.Register

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.example.foodcookbook.activities.LoginActivity
import com.example.foodcookbook.activities.MainActivity
import com.example.foodcookbook.databinding.ActivityUserRegisterBinding
import com.example.foodcookbook.models.AccessResultModel
import com.example.foodcookbook.viewmodel.UserRegisterViewModel
import com.example.foodcookbook.views.component.DatePickerFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class UserRegisterActivity : AppCompatActivity() {

    var binding: ActivityUserRegisterBinding? = null
    private val viewModelUserRegister: UserRegisterViewModel by viewModels()
    var dateBirthdayServices: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.imgCalendar?.setOnClickListener {
            val dialogDate =
                DatePickerFragment { year, month, day -> mostrarResult(year, month, day) }
            dialogDate.show(supportFragmentManager, "DatePicker")
        }

        binding?.btnUserRegister?.setOnClickListener {

            if(binding?.edPwd?.text.toString() == binding?.edRepeatPwd?.text.toString())
            {
                userRegister(
                    binding?.edFirstName?.text.toString(),
                    binding?.edLastName?.text.toString(),
                    binding?.edEmail?.text.toString(),
                    binding?.edPwd?.text.toString(),
                    dateBirthdayServices
                )
            }
            else{
                binding?.btnUserRegister?.isEnabled = false
                Toast.makeText(this,"password and repeat password does not match", Toast.LENGTH_SHORT).show()
            }
        }
        binding?.tvRegresar?.setOnClickListener {
            startActivityLogin()
        }

        initUserRegisterObserver()
    }

    //Callback
    private val userRegisterResult = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {
            Toast.makeText(this,"Successful registration", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"an error has ocurred", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initUserRegisterObserver() {
        viewModelUserRegister.userRegisterLD.observe(this,userRegisterResult)
    }

    fun userRegister(firstName:String, lastName:String, email:String, password:String, birthDate:String)
    {
        viewModelUserRegister.UserRegister(firstName,lastName,email,password,birthDate)
    }

    private fun mostrarResult(year: Int, month: Int, day: Int) {
        val mo = ("0" + month.toString()).takeLast(2)
        binding?.birthDate?.text = "$day/$mo/$year"
        dateBirthdayServices = "$year-$mo-$day"
    }

    fun startActivityLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}