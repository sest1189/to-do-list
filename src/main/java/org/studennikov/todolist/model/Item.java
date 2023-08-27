package org.studennikov.todolist.model;

import java.util.UUID;

public class Item {
    private final UUID id;
    private String title;
    private String description;
    private UUID userId;

    public Item(UUID id, String title, String description, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
