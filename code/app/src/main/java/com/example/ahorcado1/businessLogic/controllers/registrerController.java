package com.example.ahorcado1.businessLogic.controllers;

import com.example.ahorcado1.dataAccess.models.User;
import com.example.ahorcado1.dataAccess.repositories.UserRepository;
import com.j256.ormlite.support.ConnectionSource;

public class registrerController {
    public ConnectionSource connection;
    public registrerController( ConnectionSource connection){
        this.connection= connection;
    }
    public boolean registrer(String name,String username,String password){//devuelve un booleano
        UserRepository userRepository= new UserRepository(connection);
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
