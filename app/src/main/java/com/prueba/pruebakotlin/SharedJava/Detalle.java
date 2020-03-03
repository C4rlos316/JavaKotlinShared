package com.prueba.pruebakotlin.SharedJava;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prueba.pruebakotlin.R;

public class Detalle extends AppCompatActivity {


    TextView txtNombre;
    Button btnCerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);

        SharedPreferences preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor=preferences.edit();


        btnCerrar=findViewById(R.id.btnCerrarSesion);


        txtNombre =findViewById(R.id.txtNombre);

        cargarPreferencias();


        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.clear();
                editor.apply();
                Intent intent= new Intent(Detalle.this,SharedJava.class);
                startActivity(intent);
                finish();


            }
        });



    }


    private void cargarPreferencias() {

        SharedPreferences preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);


        String correo=preferences.getString("user","");
        String contrasena=preferences.getString("contrasena","");

        txtNombre.setText(correo);


    }
}
