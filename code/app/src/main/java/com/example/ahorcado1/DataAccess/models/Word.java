package com.example.ahorcado1.DataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Word")
public class Word {

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField(canBeNull = false)
    private int category;
    @DatabaseField(canBeNull = false)
    private String word;
    
    public Word() {
    }

    public Word(Long id, int category, String word) {
        this.id = id;
        this.category = category;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
