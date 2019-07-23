package com.example.ahorcado1.DataAccess.repositories;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public List<Word> getWordsByCatDif(Category category, int dif){
        List<Word> words = new LinkedList<>();
        try
        {
            words = wordDao.query(wordDao.queryBuilder().where().eq("category_id",category.getId()).and().eq("difficulty",dif).prepare());
            return words;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return words;
    }

    public boolean deleteWords(String[] word){
        try {
            for (int i=0;i<word.length;i++){
                wordDao.deleteById(getByWord(word[i]).getId());
            }
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteWordByCategory(Category category){
       List<Word> words = getByCategories(category);
       String[] wordsToDel = new String[words.size()];
       for (int i = 0; i < words.size(); i++) {
           wordsToDel[i] = words.get(i).getWord();
       }
       return deleteWords(wordsToDel);
    }

    public Word getByWord(String name){
        try
        {
            List<Word> words = wordDao.query(wordDao.queryBuilder().where().eq("word",name).prepare());
            if (words.size()!=0) return words.get(0);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new Word();
    }
    public List<Word> getByCategories(Category category){
        List<Word> words = new LinkedList<>();
        try
        {
            return wordDao.query(wordDao.queryBuilder().where().eq("category_id",category.getId()).prepare());
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return words;
    }

    public List<Word> getAllWords(){
        List<Word> words = new LinkedList<>();

        try{
            words = wordDao.query(wordDao.queryBuilder().prepare());
            return words;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return words;
    }

}
