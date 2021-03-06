package com.example.ahorcado1.DataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User
{
    //Generate id --> PK
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String completeName;
    @DatabaseField(canBeNull = false,unique = true)
    private String username;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField(canBeNull = false)
    private int scoreAccum;//mODIFICAR POR SCOREACCUM
    @DatabaseField(canBeNull = false)
    private Boolean adminOrUser;
    //@DatabaseField(foreign = true) //Asi se trabajan con llaves foraneas, usuario no tiene pero partida si debe tener de llave foranea del usuario
    //private Partida partida; EJEMPLO

    //Constructor de User tiene por defecto id = -1. Si un usario en los controladores tiene id = -1 significa que no exite en la base de datos.
    public User(){
        this.id = -1;
    }

    public User(String completeName,String username,String password, Boolean adminOrUser)
    {
        this.setCompleteName(completeName);
        this.setUsername(username);
        this.setPassword(password);
        this.setScoreAccum(0);
        this.setAdminOrUser(adminOrUser);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getScoreAccum() {
        return scoreAccum;
    }

    public void setScoreAccum(int scoreAccum) {
        this.scoreAccum = scoreAccum;
    }

    public Boolean getAdminOrUser() {
        return adminOrUser;
    }

    public void setAdminOrUser(Boolean adminOrUser) {
        this.adminOrUser = adminOrUser;
    }
}
