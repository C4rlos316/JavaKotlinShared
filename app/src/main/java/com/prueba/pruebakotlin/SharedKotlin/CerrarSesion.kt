package com.prueba.pruebakotlin.SharedKotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prueba.pruebakotlin.R

import kotlinx.android.synthetic.main.activity_cerrar_sesion.*

class CerrarSesion : AppCompatActivity() {

   // var token=getSharedPreferences("loginUser",Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerrar_sesion)
        setSupportActionBar(toolbar)

        val sharedPreferences = getSharedPreferences("loginUser", Context.MODE_PRIVATE)

        val editar = sharedPreferences.edit()

        val nombre=intent.getStringExtra("nombre")

        txtNombre.text=nombre


        btnCerrarSesion.setOnClickListener {

            editar.clear()
            editar.apply()
           val intent=Intent(this, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()

        }

    }

}
