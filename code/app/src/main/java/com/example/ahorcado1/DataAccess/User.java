package com.example.ahorcado1.DataAccess;

public class User
{
    private int id;
    private String username; //id y username son únicos e irrepetibles
    private String completeName;
    private int password;
    private int puntaje;

    public User()
    {

    }

    public User(int id, String username, String completeName, int password, int puntaje)
    {
        this.id = id;
        this.username = username;
        this.completeName = completeName;
        this.password = password;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
