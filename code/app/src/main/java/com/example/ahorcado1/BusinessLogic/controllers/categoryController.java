package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;

public class categoryController {
    public categoryController(){

    }
    public boolean createCategory(String name, int difficulty, String words[] ){
        CategoryRepository categoryRepository = Globals.categoryRepository;
        Category category = new Category(name,difficulty);
        if (!categoryRepository.create(category)) return false;
        category = categoryRepository.getByName(name);
        Word word;
        WordRepository wordRepository = Globals.wordRepository;
        for (int i = 0; i < words.length ; i++ ){
            word = new Word(category,words[i]);
            if (!wordRepository.create(word)) return false;
        }
        return true;
    }
}
