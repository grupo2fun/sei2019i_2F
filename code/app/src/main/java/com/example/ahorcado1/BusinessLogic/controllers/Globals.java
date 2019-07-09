package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.database.Database;
import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.j256.ormlite.support.ConnectionSource;

public final class Globals {
    public static Database database = new Database();

    public static User user;
    public static UserRepository userRepository = new UserRepository(database.connection);



}