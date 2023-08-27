package org.studennikov.todolist.service.impl;

import org.springframework.stereotype.Service;
import org.studennikov.todolist.model.Item;
import org.studennikov.todolist.service.ItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    public List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getItemsByUserId(UUID userId) {
        return items.stream().filter(i -> userId.equals(i.getUserId())).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> getItemById(UUID itemId) {
        return items.stream().filter(i -> itemId.equals(i.getId())).findFirst();
    }

    @Override
    public void deleteItemByItemId(UUID itemId) {
        items.removeIf(i -> itemId.equals(i.getId()));
    }

    @Override
    public Item addItem(UUID userId, String title, String description) {
        Item item = new Item(UUID.randomUUID(), title, description, userId);
        items.add(item);
        return item;
    }

    @Override
    public Optional<Item> editItem(UUID itemId, UUID userId, String title, String description) {
        Optional<Item> item = items.stream().filter(i -> itemId.equals(i.getId())).findFirst();
        item.ifPresent(i -> {
            i.setUserId(userId);
            i.setDescription(description);
            i.setTitle(title);
        });
        return item;
    }
}
