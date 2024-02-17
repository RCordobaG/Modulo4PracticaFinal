package com.rodricorgom.modulo4practicafinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val registerBtn = findViewById<Button>(R.id.registroBtn)

        val sendUserIntent = Intent(this,getInfoActivity::class.java)

        var correo = findViewById<EditText>(R.id.emailTxt)
        var password = findViewById<EditText>(R.id.passwordTxt)
        var nombre = findViewById<EditText>(R.id.nombreTxt)
        var apellido = findViewById<EditText>(R.id.apellidoTxt)
        var genero = findViewById<RadioGroup>(R.id.radioGroup)





        registerBtn.setOnClickListener{
            var generoId = findViewById<RadioButton>(genero.checkedRadioButtonId)
            val dataIntent = Intent(this,getInfoActivity::class.java).apply{
                putExtra("email",correo.text.toString())
                putExtra("pass",password.text.toString())
                putExtra("name",nombre.text.toString())
                putExtra("surname",apellido.text.toString())
                putExtra("gender",generoId.text.toString())
            }
            startActivity(dataIntent)
        }
    }
}