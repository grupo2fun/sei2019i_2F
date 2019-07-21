package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.CategoryRepository;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;

import java.util.List;

public class categoryController {
    public categoryController(){

    }

    //Creación del registro cateogoría
    public boolean createCategory(String name)
    {
        Category category = new Category(name);
        if (!Globals.categoryRepository.create(category)) return false;
        return true;
    }

    public Category getCategory(int idCategory)
    {
        Category category = Globals.categoryRepository.getById(idCategory);
        return category;
    }

    public boolean deleteCategories(String[] names)
    {
        return Globals.categoryRepository.deleteCategories(names);
    }

    public List<Category> getAllCategories()
    {
        CategoryRepository categoryRepository = Globals.categoryRepository;
        return categoryRepository.getAllCategories();
    }
}
