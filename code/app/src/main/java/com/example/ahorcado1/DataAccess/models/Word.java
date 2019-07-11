package com.example.ahorcado1.DataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Word")
public class Word {

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField(canBeNull = false, foreign = true)
    private Category category;
    @DatabaseField(canBeNull = false)
    private String word;

    public Word() {
    }

    public Word(Category category, String word) {
        this.category = category;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
