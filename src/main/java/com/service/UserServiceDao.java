package com.service;

import com.models.Role;
import com.models.User;

import java.util.List;

public interface UserServiceDao {

    public void register(User user);

    public List<User> getAllUsers();

    public List<Role> getAllRoles();
}
