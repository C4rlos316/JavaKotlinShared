package com.prueba.pruebakotlin.SharedKotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prueba.pruebakotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mostrarDatos()



        btnEntrar.setOnClickListener {

            val nombre = editText.text.toString().trim()
            val contrasena = edtContrasena.text.toString().trim()
            val guardar = checkBox.isChecked


            if (checkBox.isChecked) {

            if (!nombre.isEmpty() && !contrasena.isEmpty()) {

                val intent = Intent(this, CerrarSesion::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("correo", contrasena)
                startActivity(intent)

                guardarDatos(nombre, contrasena, guardar)

            } else {

                Toast.makeText(this, getString(R.string.msg_mal), Toast.LENGTH_LONG).show()


            }

        }

            else{

                if (!nombre.isEmpty() && !contrasena.isEmpty()) {

                    val intent = Intent(this, CerrarSesion::class.java)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("correo", contrasena)
                    startActivity(intent)

                    //guardarDatos(nombre, contrasena, guardar)

                } else {

                    Toast.makeText(this, getString(R.string.msg_mal), Toast.LENGTH_LONG).show()


                }

            }

        }

    }


    private fun guardarDatos(nombre: String, contrasena: String,checkBox:Boolean) {

        val sharedPreferences = getSharedPreferences("loginUser", Context.MODE_PRIVATE)


        val editar = sharedPreferences.edit()
        editar.putString("NAME", nombre)
        editar.putString("CONTRASENA", contrasena)
        editar.putBoolean("CHECK", checkBox)
        editar.apply()

    }


    private fun mostrarDatos() {

        val sharedPreferences = getSharedPreferences("loginUser", Context.MODE_PRIVATE)


        val nombre = sharedPreferences.getString("NAME", "")
        val contrasena = sharedPreferences.getString("CONTRASENA", "")
        val check = sharedPreferences.getBoolean("CHECK", false)


        editText.setText(nombre)
        edtContrasena.setText(contrasena)
        checkBox.isChecked=check


    }

}
