package com.dao;

import com.models.Role;

import java.util.List;

public interface RoleDao {

    public void addRole(Role role);

    public List<Role> roleList();
}
