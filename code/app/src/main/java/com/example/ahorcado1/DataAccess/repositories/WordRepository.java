package com.example.ahorcado1.DataAccess.repositories;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class WordRepository {

    Dao<Word,Long> wordDao ;
    public WordRepository(ConnectionSource connection){
        try {
            wordDao = DaoManager.createDao(connection, Word.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean create(Word word){
        try {
            wordDao.create(word);
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Word update(Word word){
        try {
            wordDao.update(word);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return word;
    }

    public Word getById(long id){
        try {
            return wordDao.queryForId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Word();
    }

}
