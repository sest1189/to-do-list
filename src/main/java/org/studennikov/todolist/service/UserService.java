package org.studennikov.todolist.service;

import org.studennikov.todolist.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> getUserById(UUID userId);

    Optional<User> getUserByUserName(String userName);

    User addUser(String userName);
}
