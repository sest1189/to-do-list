package org.studennikov.todolist.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String userName;

    public User(UUID id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
