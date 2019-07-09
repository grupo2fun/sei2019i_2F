package com.example.ahorcado1.DataAccess.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "round")
public class Round {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private Long user;
    @DatabaseField(canBeNull = false)
    private int category;
    @DatabaseField(canBeNull = false)
    private Long score;

    public Round() {
    }

    public Round(Long user, int category, Long score) {
        this.user = user;
        this.category = category;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
