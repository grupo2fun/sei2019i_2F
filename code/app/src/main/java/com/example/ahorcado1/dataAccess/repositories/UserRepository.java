package com.example.ahorcado1.DataAccess.repositories;



import com.example.ahorcado1.DataAccess.models.User;
//import com.example.ahorcado1.dataAccess.models.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class UserRepository {
    Dao<User,Long> userDao ;
    public UserRepository(ConnectionSource connection){
        try {
            userDao = DaoManager.createDao(connection, User.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User create(User user){
        try {
            userDao.create(user);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public User update(User user){
        try {
            userDao.update(user);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public User getById(long id){
        try {
            return userDao.queryForId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new User();
    }
    public User getByUsername(String username){
        try {
            List<User> users = userDao.query(userDao.queryBuilder().where().eq("username",username).prepare());
            if (users.size()==0) return new User();
            else return users.get(0);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new User();
    }

}
