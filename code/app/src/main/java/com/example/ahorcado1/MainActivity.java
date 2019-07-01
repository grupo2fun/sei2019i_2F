package com.example.ahorcado1;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahorcado1.dataAccess.database.Database;
import com.example.ahorcado1.dataAccess.models.User;
import com.example.ahorcado1.dataAccess.repositories.UserRepository;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //For network connections in main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Database database = new Database();
        User newUser = new User("Ivan321","F9 Maurice","0000");
        UserRepository userRepo = new UserRepository(database.connection);
        userRepo.create(newUser);


    }
}
