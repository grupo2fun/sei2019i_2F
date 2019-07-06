package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.support.ConnectionSource;

public class registerController {

    public registerController(){}

    public boolean register (String name,String username,String password){//devuelve un booleano
        UserRepository userRepository = Globals.userRepository;
        User user1 = userRepository.getByUsername(username);
        if(user1.getId()==-1){
            User user = new User(name,username,password);
            userRepository.create(user);
            return true;//devuelve true si no existe un usuario con ese usename y lo añade a la base de datos
        }else{
            return false;//devuelve falso si ya existe un usario con ese username
        }
    }
}
