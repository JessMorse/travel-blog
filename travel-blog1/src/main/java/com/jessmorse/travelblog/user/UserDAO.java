package com.jessmorse.travelblog.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void addUserToDatabase(User user);
    void removeUserFromDatabase(long userId);
    Optional<User> getUserById(long id);
    void updateUser(long userId, User user);
    List<User> getAllUsers();

}
