package com.example.ahorcado1.BusinessLogic.controllers;
import android.util.Log;

import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.j256.ormlite.support.ConnectionSource;

public class loginController {

    public ConnectionSource connection;
    public loginController( ConnectionSource connection){
        this.connection= connection;
    }

    public User loginUser (String user, String Password){
        UserRepository userRepository = new UserRepository(connection);

        User user1= userRepository.getByUsername(user);

        if(user1.getId()==-1){
            return new User();
        }
        else if(user1.getPassword().equals(Password)){
            return user1;
        }
        return new User();
    }
}
