package com.example.ahorcado1;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.loginController;
import com.example.ahorcado1.BusinessLogic.controllers.registerController;
import com.example.ahorcado1.DataAccess.database.Database;

public class registerUserActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Instancia de Base de Datos
        Database database = new Database();
        final registerController registerController1 = new registerController(database.connection);

        e1 = (EditText) findViewById(R.id.userName);
        e2 = (EditText) findViewById(R.id.nameUserText);
        e3 = (EditText) findViewById(R.id.passUserText);
        br = (Button) findViewById(R.id.buttonRegister);

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
