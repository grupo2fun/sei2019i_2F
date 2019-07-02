package com.example.ahorcado1;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.example.ahorcado1.DataAccess.database.Database;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Database
        Database database = new Database();
        //New User
        User newUser = new User("Ivan321","F9 Maurice","0000");
        UserRepository userRepo = new UserRepository(database.connection);
        userRepo.create(newUser);


    }
}
