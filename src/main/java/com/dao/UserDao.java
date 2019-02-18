package com.dao;


import com.models.Login;
import com.models.User;

import java.util.List;

public interface UserDao {

    public void register(User user);

    public User validateUser(Login login);

    public List<User> userList();
}
