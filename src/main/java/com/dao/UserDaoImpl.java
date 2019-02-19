package com.dao;

import com.models.Role;
import com.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    public List<User> getAllUsers()
    {
        List<User> users = manager.createQuery("Select a From User a", User.class).getResultList();
        return users;
    }

    public List<Role> getAllRoles()
    {
        List<Role> roles = manager.createQuery("Select a From Role a", Role.class).getResultList();
        return roles;
    }

    public void register(User user) {

        user.setRole(getRoleById(user.getRole().getId()));

        manager.persist(user);
    }

    public Role getRoleById(Integer id)
    {
        return manager.find(Role.class, id);
    }
}

