package com.jessmorse.travelblog.user;

import com.jessmorse.travelblog.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;

    //@Autowired
    public UserService(@Qualifier("User") UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void addUserToDatabase(User user){
        userDAO.addUserToDatabase(user);
    }


    public void removeUserFromDatabase(long id) {
        if (userDAO.getUserById(id).isEmpty()){
            throw new ResourceNotFound("User with this id does not exist");
        }
        userDAO.removeUserFromDatabase(id);
    }


    public Optional<User> getUserById(long id) {
        if (userDAO.getUserById(id).isEmpty()) {
            throw new ResourceNotFound("User with this id not found :/");
        };
        return userDAO.getUserById(id);
    }


    public void updateUser(long id, User user) {
        if (userDAO.getUserById(id).isEmpty()) {
            throw new ResourceNotFound("User with this id not found :/");
        };

        userDAO.updateUser(id, user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    };
}

