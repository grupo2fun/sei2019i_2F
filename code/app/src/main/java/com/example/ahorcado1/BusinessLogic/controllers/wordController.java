package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;

import java.util.List;

public class wordController {
    public wordController(){}

    public boolean writeWord (Category category,Word word)
    {
        WordRepository wordRepository= Globals.wordRepository;
        boolean isTrue = wordRepository.create(word);
        return isTrue;
    }

    public List<Word> getWordsByCatDif (Category category, int dif){
        return Globals.wordRepository.getWordsByCatDif(category,dif);
    }

    public boolean deleteWords(String[] words){
        return Globals.wordRepository.deleteWords(words);
    }

    public List<Word> getAllWords()
    {
        return Globals.wordRepository.getAllWords();
    }

}
