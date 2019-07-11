package com.example.ahorcado1.BusinessLogic.controllers;


import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;


public class loginController {

    public loginController( ){ }

    public User loginUser (String user, String Password)
    {
        UserRepository userRepository = Globals.userRepository;

        User user1 = userRepository.getByUsername(user);

        if(user1.getId() == -1)
        {
            return new User();
        }
        else if(user1.getPassword().equals(Password)){
            return user1;
        }
        return new User();
    }
}
