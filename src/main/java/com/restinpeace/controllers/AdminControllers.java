package com.restinpeace.controllers;

import com.restinpeace.entities.Role;
import com.restinpeace.entities.User;
import com.restinpeace.service.RoleService;
import com.restinpeace.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


@RestController
@RequestMapping("/rest/admin")
public class AdminControllers {

    @Autowired
    private PasswordEncoder encoder;

    private final UserServiceImpl userService;

    public AdminControllers(UserServiceImpl userService) {
        this.userService = userService;
    }



    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.listUsers();
    }

    @PostMapping("/users")
    public void addNewUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveOrUpdateUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userService.saveOrUpdateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable Long id) {
        try {
            User user = userService.getUserByID(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
