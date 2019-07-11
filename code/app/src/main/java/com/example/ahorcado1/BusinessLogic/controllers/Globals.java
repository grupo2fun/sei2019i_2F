package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.database.Database;
import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;
import com.j256.ormlite.support.ConnectionSource;

public final class Globals {
    public static Database database = new Database();

    public static User user;
    public static UserRepository userRepository = new UserRepository(database.connection);

    public static Word word;
    public static WordRepository wordRepository = new WordRepository(database.connection);
    public static CategoryRepository categoryRepository = new CategoryRepository(database.connection);



}