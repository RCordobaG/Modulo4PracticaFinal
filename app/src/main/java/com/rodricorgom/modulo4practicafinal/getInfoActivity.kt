package com.rodricorgom.modulo4practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class getInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_info)

        var extMail = intent.getStringExtra("EXTRA_EMAIL")
        var extPass = intent.getStringExtra("EXTRA_PASSWORD")
        var extName = intent.getStringExtra("EXTRA_NAME")
        var extSurname = intent.getStringExtra("EXTRA_SURNAME")
        var extGender = intent.getStringExtra("EXTRA_GENDER")
        var extType = intent.getStringExtra("EXTRA_TYPE")




        val nameText = findViewById<TextView>(R.id.getName)
        val surnameText = findViewById<TextView>(R.id.getSurname)
        val genderText = findViewById<TextView>(R.id.getGender)
        val emailText = findViewById<TextView>(R.id.getEmail)
        val passwordText = findViewById<TextView>(R.id.getPassword)
        val typeText = findViewById<TextView>(R.id.getType)
        nameText.text = extName
        surnameText.text = extSurname
        genderText.text = extGender
        emailText.text = extMail
        passwordText.text = extPass
        typeText.text = extType

    }
}