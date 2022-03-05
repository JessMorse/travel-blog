package com.jessmorse.travelblog.user;

//import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("email"),
                rs.getString("user_password")
        );
        return user;
    }
}
