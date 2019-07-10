package com.example.ahorcado1.Presentation;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.registerController;

import com.example.ahorcado1.R;

public class registerUserActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        //For network connections in main thread

        final registerController registerController1 = new registerController();

        //Cajas de texto
        e1 = (EditText) findViewById(R.id.userNameText);
        e2 = (EditText) findViewById(R.id.nameUserText);
        e3 = (EditText) findViewById(R.id.passUserText);
        //Botón registrar
        br = (Button) findViewById(R.id.buttonRegister);

        //Acción del botón "Registrar"
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(registerController1.register(e1.getText().toString(), e2.getText().toString(),e3.getText().toString())){
                    Intent i =new Intent(registerUserActivity.this,mainMenuActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"El usuario ya se encuentra registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
