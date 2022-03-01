package com.jessmorse.travelblog.user;

import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Autowired
    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user = new User(
                rs.getInt("id"),
                rs.getString("UserName"),
                rs.getString("UserEmail"),
                rs.getString("UserPassword")
        );
        return user;
    }
}
