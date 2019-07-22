package com.example.ahorcado1.DataAccess.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Round")
public class Round {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, foreign = true)
    private User user;
    @DatabaseField(canBeNull = false, foreign = true)
    private Category category;
    @DatabaseField(canBeNull = false)
    private Long score;



    public Round() {
    }

    public Round(User user, Category category, Long score) {
        this.user = user;
        this.category = category;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
