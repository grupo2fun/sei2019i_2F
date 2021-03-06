package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.database.Database;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Round;
import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;
import com.example.ahorcado1.DataAccess.repositories.RoundRepository;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;
import com.j256.ormlite.support.ConnectionSource;

public final class Globals {

    public static Database database = new Database();
    //Usuario
    public static User user;
    public static UserRepository userRepository = new UserRepository(database.connection);
    //Palabra
    public static Word word;
    public static WordRepository wordRepository = new WordRepository(database.connection);
    //Categoria
    public static CategoryRepository categoryRepository = new CategoryRepository(database.connection);
    public static Category category = new Category();
    //Ronda
    public static RoundRepository roundRepository = new RoundRepository(database.connection);
    public static Round round = new Round();
    public static int dif;


}