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
    @DatabaseField(canBeNull = false)
    private int difficulty;

    public Word() {
    }

    public Word(Category category, String word, int difficulty) {
        this.category = category;
        this.word = word;
        this.difficulty = difficulty;
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

    public int getDifficult() {return difficulty;}

    public void setDifficult(int difficult) {this.difficulty = difficult;}
}
