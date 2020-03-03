package com.prueba.pruebakotlin.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.prueba.pruebakotlin.R;
import com.prueba.pruebakotlin.SharedJava.Detalle;

public class SharedMejor  extends AppCompatActivity {

    EditText edtContrasena;
    EditText edtCorreo;

    Button btnEntrar;

    Switch aSwitch;

    private SharedUtils utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtContrasena=findViewById(R.id.edtContrasena);
        edtCorreo=findViewById(R.id.editText);

        utils=SharedUtils.getInstance(this);


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



                        Intent intent= new Intent(getApplicationContext(), Detalle.class);
                        startActivity(intent);
                        startActivity(intent);

                        guardarPreferencias(nombre, contrasena,guardar);

                    } else {


                        Toast.makeText(getApplicationContext(), getString(R.string.msg_mal), Toast.LENGTH_LONG).show();


                    }

                }

                else{

                    if (!nombre.isEmpty() && !contrasena.isEmpty()) {

                        Intent intent= new Intent(getApplicationContext(),Detalle.class);
                        intent.putExtra("nombre", nombre);
                        startActivity(intent);


                    } else {

                        Toast.makeText(getApplicationContext(), getString(R.string.msg_mal), Toast.LENGTH_LONG).show();


                    }

                }

            }
        });



    }

    private void cargarPreferencias() {

        edtCorreo.setText(utils.getString("user"));
        edtContrasena.setText(utils.getString("contrasena"));
          aSwitch.setChecked(utils.getBoolean("check",false));


    }


    private void guardarPreferencias(String correo,String contrasena, Boolean guardar){

        utils.putString("user",correo);
        utils.putString("contrasena",contrasena);
        utils.putBoolean("check",guardar);


    }


}
