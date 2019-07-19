package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;

import java.util.List;

public class adminController {

    public adminController(){

    }

    public List<Category> getAllCategories(){
        CategoryRepository categoryRepository = Globals.categoryRepository;
        return categoryRepository.getAllCategories();
    }

}
