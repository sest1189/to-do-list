package org.studennikov.todolist.service.impl;

import org.springframework.stereotype.Service;
import org.studennikov.todolist.model.User;
import org.studennikov.todolist.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    public List<User> users = new ArrayList<>();

    @Override
    public Optional<User> getUserById(UUID userId) {
        return users.stream().filter(u -> userId.equals(u.getId())).findFirst();
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return users.stream().filter(u -> userName.equals(u.getUserName())).findFirst();
    }

    @Override
    public User addUser(String userName) {
        User user = new User(UUID.randomUUID(), userName);
        users.add(user);
        return user;
    }
}
