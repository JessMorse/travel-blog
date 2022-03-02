package com.jessmorse.travelblog.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("user")
public class UserDataAccessService implements UserDAO {

    //Create instance of rowMapper
    @Autowired
    UserRowMapper autowiredRowMapper;
    //TODO: create rowMapper

    private JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUserToDatabase(User user) {
        String sql = """
                INSERT INTO users(user_name, email, user_password)
                VALUES (?, ?, ?);""";

        jdbcTemplate.update(sql, user.getUserName(), user.getEmail(), user.getPassword());

    }

    @Override
    public void removeUserFromDatabase(long userId) {
        String sql = """
                DELETE FROM users WHERE user_id = ?;""";
        jdbcTemplate.update(sql, userId);

    }

    @Override
    public Optional<User> getUserById(long id) {
        String sql = """
                SELECT * FROM users WHERE id = ?;""";
        return jdbcTemplate.query(sql,autowiredRowMapper, id).stream().findAny();
    }

    @Override
    public void updateUser(long userId, User user) {
        String sql = """
                UPDATE users SET user_name = ?, email = ?, user_password = ? WHERE  user_id = ?;""";
        jdbcTemplate.update(sql, user.getUserName(), user.getEmail(), user.getPassword(), userId);
    }

    @Override
    public List<User> getAllUsers(){
        String sql = """
                SELECT * FROM users;""";
        return jdbcTemplate.query(sql, autowiredRowMapper);
    }
}
