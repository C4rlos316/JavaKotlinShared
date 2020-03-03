package com.prueba.pruebakotlin.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prueba.pruebakotlin.R;
import com.prueba.pruebakotlin.SharedJava.SharedJava;

public class DetalleMejor  extends AppCompatActivity {


    TextView txtNombre;

    Button btnCerrar;

    private SharedUtils utils;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);

        utils=SharedUtils.getInstance(this);


        btnCerrar=findViewById(R.id.btnCerrarSesion);


        txtNombre =findViewById(R.id.txtNombre);

        cargarPreferencias();


        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                utils.clear();
                Intent intent= new Intent(getApplicationContext(), SharedJava.class);
                startActivity(intent);
                finish();


            }
        });



    }


    private void cargarPreferencias() {

        txtNombre.setText(utils.getString("user"));


    }
}
