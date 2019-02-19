package com.service;

import com.dao.UserDao;
import com.models.Role;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<Role> getAllRoles() {
        return userDao.getAllRoles();
    }

    public void register(User user) {
        userDao.register(user);
    }
}
