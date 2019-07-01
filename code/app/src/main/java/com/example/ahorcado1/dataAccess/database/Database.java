package com.example.ahorcado1.dataAccess.database;


import com.example.ahorcado1.dataAccess.models.User;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    private static final String HOST = "jdbc:mysql://192.168.0.3:3306/";        //Direccion ip de la base
    private static final String DB_NAME = "db_hangman";
    private static final String CONNECTION = HOST + DB_NAME;
    private static final String USER = "hangManUser";
    private static final String PASS = "0000";
    public ConnectionSource connection;
    public Database() {
        try {
            connection = new JdbcConnectionSource(CONNECTION, USER, PASS);
            TableUtils.createTableIfNotExists(connection, User.class);
            //TableUtils.createTableIfNotExists(connection, Rol.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
