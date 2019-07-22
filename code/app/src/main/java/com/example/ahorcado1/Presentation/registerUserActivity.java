package com.example.ahorcado1.Presentation;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.*;

import com.example.ahorcado1.R;



public class registerUserActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button br;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        //Instancia de controlador
        final registerController registerController1 = new registerController();

        //Cajas de texto
        e1 = (EditText) findViewById(R.id.nameUserText);
        e2 = (EditText) findViewById(R.id.nicknameText);
        e3 = (EditText) findViewById(R.id.passUserText);
        //Botón registrar
        br = (Button) findViewById(R.id.buttonRegister);

        //Acción del botón "Registrar"
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( registerController1.register( e1.getText().toString(), e2.getText().toString(),e3.getText().toString(), false ) )
                {
                    Intent i =new Intent(registerUserActivity.this,loginUserActivity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(),"El usuario ya se encuentra registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
