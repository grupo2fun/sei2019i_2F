package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.loginController;
import com.example.ahorcado1.DataAccess.database.Database;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.example.ahorcado1.R;

public class loginUserActivity extends AppCompatActivity {
    EditText e1,e2;
    Button be,br;

    //Datos de usuario
    String user;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Instancia de Base de Datos



        //Instancia de controller
        final loginController loginController1 = new loginController();

        e1=(EditText)findViewById(R.id.userName);
        e2=(EditText)findViewById(R.id.Lpassword);
        be=(Button) findViewById(R.id.buttonEntrar);
        br=(Button) findViewById(R.id.buttonRegistro);

        be.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Si el id del usuario es diferente de -1
                user = e1.getText().toString();
                password = e2.getText().toString();
                if( loginController1.loginUser( user, password ).getId() != -1 )
                {
                    //Instancia global de User
                    Intent i = new Intent(loginUserActivity.this, mainMenuActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
                }
            }

        });

        br.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Intent i =new Intent(loginUserActivity.this,registerUserActivity.class);
                Intent i =new Intent(loginUserActivity.this, registerUserActivity.class);
                startActivity(i);
            }
        });
    }

}
