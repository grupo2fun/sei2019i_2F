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
import com.example.ahorcado1.DataAccess.database.Database;

public class loginUserActivity extends AppCompatActivity {
    EditText e1,e2;
    Button be,br;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Instancia de Base de Datos
        Database database = new Database();
        final loginController loginController1= new loginController(database.connection);

        e1=(EditText)findViewById(R.id.userName);
        e2=(EditText)findViewById(R.id.Lpassword);
        be=(Button) findViewById(R.id.buttonEntrar);
        br=(Button) findViewById(R.id.buttonRegistro);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginController1.loginUser(e1.getText().toString(),e2.getText().toString()).getId()!=-1){
                    Intent i =new Intent(loginUserActivity.this,mainMenuActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
                }
            }

        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(loginUserActivity.this,registerUserActivity.class);
                startActivity(i);
            }
        });
    }

}
