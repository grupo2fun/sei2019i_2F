package com.example.ahorcado1.dataAccess.repositories;

import com.example.ahorcado1.dataAccess.models.Account;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class AccountRepo {
    Dao<Account,String> accountDao;
    public AccountRepo(ConnectionSource connection){
        try {
            accountDao = DaoManager.createDao(connection, Account.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
