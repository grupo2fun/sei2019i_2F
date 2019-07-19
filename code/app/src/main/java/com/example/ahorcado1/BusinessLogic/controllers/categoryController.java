package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;

public class categoryController {
    public categoryController(){

    }
    public boolean createCategory(String name){
        Category category = new Category(name);
        if (!Globals.categoryRepository.create(category)) return false;
        return true;
    }
    public boolean deleteCategories(String[] names){
        return Globals.categoryRepository.deleteCategories(names);
    }
}
