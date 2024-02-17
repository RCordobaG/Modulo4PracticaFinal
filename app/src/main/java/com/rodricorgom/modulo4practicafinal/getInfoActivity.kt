package com.rodricorgom.modulo4practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class getInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_info)

        var extMail = intent.getStringExtra("email")
        var extPass = intent.getStringExtra("pass")
        var extName = intent.getStringExtra("name")
        var extSurname = intent.getStringExtra("surname")
        var extGender = intent.getStringExtra("gender")




        val nameText = findViewById<TextView>(R.id.getName)
        val surnameText = findViewById<TextView>(R.id.getSurname)
        val genderText = findViewById<TextView>(R.id.getGender)
        val emailText = findViewById<TextView>(R.id.getEmail)
        val passwordText = findViewById<TextView>(R.id.getPassword)
        nameText.text = extName
        surnameText.text = extSurname
        genderText.text = extGender
        emailText.text = extMail
        passwordText.text = extPass

    }
}