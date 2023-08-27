package org.studennikov.todolist.service;

import org.studennikov.todolist.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemService {

    List<Item> getItemsByUserId(UUID userId);

    Optional<Item> getItemById(UUID itemId);

    void deleteItemByItemId(UUID itemId);

    Item addItem(UUID userId, String title, String description);

    Optional<Item> editItem(UUID itemId, UUID userId, String title, String description);
}
