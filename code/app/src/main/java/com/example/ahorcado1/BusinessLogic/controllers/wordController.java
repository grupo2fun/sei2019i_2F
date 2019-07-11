package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.DataAccess.repositories.WordRepository;

public class wordController {
    public wordController(){}

    public boolean writeWord (Category category,Word word){
        WordRepository wordRepository= Globals.wordRepository;
        boolean isTrue = wordRepository.create(word);
        return isTrue;
    }
    /*public Word[] getWords ()*/

}
