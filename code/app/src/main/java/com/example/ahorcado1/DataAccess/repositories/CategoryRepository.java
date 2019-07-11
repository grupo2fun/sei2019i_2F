package com.example.ahorcado1.DataAccess.repositories;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Round;
import com.example.ahorcado1.DataAccess.models.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class CategoryRepository {

    Dao<Category,Long> categoryDao ;
    public CategoryRepository(ConnectionSource connection){
        try {
            categoryDao = DaoManager.createDao(connection, Category.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean create(Category category){
        try {
            categoryDao.create(category);
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Category update(Category category){
        try {
            categoryDao.update(category);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    public Category getById(long id){
        try {
            return categoryDao.queryForId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Category();
    }

}
