package com.example.ahorcado1.DataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String completeName;
    @DatabaseField(canBeNull = false,unique = true)
    private String username;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField(canBeNull = false)
    private int puntaje;

    public User(){}

    public User(String completeName,String username,String password){
        this.setCompleteName(completeName);
        this.setUsername(username);
        this.setPassword(password);
        this.setPuntaje(0);
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
