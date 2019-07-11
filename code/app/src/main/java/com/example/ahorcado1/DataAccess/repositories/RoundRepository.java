package com.example.ahorcado1.DataAccess.repositories;

import com.example.ahorcado1.DataAccess.models.Round;
import com.example.ahorcado1.DataAccess.models.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class RoundRepository {

    Dao<Round,Long> roundDao ;
    public RoundRepository(ConnectionSource connection){
        try {
            roundDao = DaoManager.createDao(connection, Round.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean create(Round round){
        try {
            roundDao.create(round);
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Round> getByUserId(Long username){
        try {
            //Probar
            List<Round> users = roundDao.query(roundDao.queryBuilder().where().eq("user",username).prepare());
            return users;
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
