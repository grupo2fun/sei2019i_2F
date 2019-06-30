package com.example.ahorcado1.dataAccess.database;


import com.example.ahorcado1.dataAccess.models.Account;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    private static final String HOST = "jdbc:mysql://192.168.0.7:3306/";
    private static final String DB_NAME = "db_hangman";
    private static final String CONNECTION = HOST + DB_NAME;
    private static final String USER = "hangManUser";
    private static final String PASS = "0000";
    private ConnectionSource connection;
    public Database() {
        try {
            connection = new JdbcConnectionSource(CONNECTION, USER, PASS);
            TableUtils.createTableIfNotExists(connection, Account.class);
            //TableUtils.createTableIfNotExists(connection, Rol.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
