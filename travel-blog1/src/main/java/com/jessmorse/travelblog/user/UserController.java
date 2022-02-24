package com.jessmorse.travelblog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUserToDatabase(@RequestBody User user) {
        userService.addUserToDatabase(user);
    }

    @DeleteMapping("{id}")
    public void removeUserFromDatabase(@PathVariable("id") long id) {
        userService.removeUserFromDatabase(id);
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    };

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody User user){
        userService.updateUser(id, user);
    };

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
