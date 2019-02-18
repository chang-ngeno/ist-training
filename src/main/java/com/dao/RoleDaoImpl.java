package com.dao;


import com.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addRole(Role role) {

        String sql = "insert into roles values(?,?)";

        jdbcTemplate.update(sql,
            new Object[] {
                    role.getName(),
                    role.getDescription()
            });
    }

    public List<Role> roleList() {

        String sql = "SELECT * FROM roles";

        return jdbcTemplate.query(sql, new RoleMapper());
    }
}

class RoleMapper implements RowMapper<Role> {

    public Role mapRow(ResultSet rs, int arg1) throws SQLException {

        Role role = new Role();

        role.setName(rs.getString("name"));
        role.setDescription(rs.getString("description"));

        return role;
    }
}
