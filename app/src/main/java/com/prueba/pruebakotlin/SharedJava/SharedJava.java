package com.prueba.pruebakotlin.SharedJava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.prueba.pruebakotlin.R;
import com.prueba.pruebakotlin.Utils.SharedUtils;

public class SharedJava extends AppCompatActivity {

    EditText edtContrasena;
    EditText edtCorreo;

    Button btnEntrar;

    Switch aSwitch;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtContrasena=findViewById(R.id.edtContrasena);
        edtCorreo=findViewById(R.id.editText);


        btnEntrar=findViewById(R.id.btnEntrar);


        aSwitch=findViewById(R.id.checkBox);


        cargarPreferencias();


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = edtCorreo.getText().toString().trim();
                String contrasena = edtContrasena.getText().toString().trim();
                Boolean guardar = aSwitch.isChecked();


                if (aSwitch.isChecked()) {

                    if (!nombre.isEmpty() && !contrasena.isEmpty()) {



                        Intent intent= new Intent(SharedJava.this,Detalle.class);
                        startActivity(intent);
                        startActivity(intent);

                        guardarPreferencias(nombre, contrasena, guardar);

                    } else {


                        Toast.makeText(SharedJava.this, getString(R.string.msg_mal), Toast.LENGTH_LONG).show();


                    }

                }

                else{

                    if (!nombre.isEmpty() && !contrasena.isEmpty()) {

                        Intent intent= new Intent(SharedJava.this,Detalle.class);
                        intent.putExtra("nombre", nombre);
                        startActivity(intent);


                    } else {

                        Toast.makeText(SharedJava.this, getString(R.string.msg_mal), Toast.LENGTH_LONG).show();


                    }

                }

            }
        });



    }

    private void cargarPreferencias() {

        SharedPreferences preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);


        String correo=preferences.getString("user","");
        String contrasena=preferences.getString("contrasena","");
        Boolean check = preferences.getBoolean("check", false);


        edtCorreo.setText(correo);
        edtContrasena.setText(contrasena);
        aSwitch.setChecked(check);


    }


    private void guardarPreferencias(String correo,String contrasena,Boolean guardar){

        SharedPreferences preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("user",correo);
        editor.putString("contrasena",contrasena);
        editor.putBoolean("check",guardar);


        editor.apply();

    }


}
