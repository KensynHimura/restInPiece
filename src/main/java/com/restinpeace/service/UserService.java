package com.restinpeace.service;

import com.restinpeace.entities.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void saveOrUpdateUser(User user);

    User getUserByID(Long id);

    public void deleteUser(Long id);
}
