package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;

public class userController {

    public userController() { }

    public boolean updateUser(User user){
        UserRepository userRepository = Globals.userRepository;
        User user1 = userRepository.update(user);
        if (user1.getUsername()==null){
            return false;
        }
        return true;
    }
}
