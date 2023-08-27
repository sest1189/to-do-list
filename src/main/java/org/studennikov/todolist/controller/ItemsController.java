package org.studennikov.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.studennikov.todolist.model.Item;
import org.studennikov.todolist.service.ItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class ItemsController {
    private final ItemService  itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(@RequestParam UUID userId) {
        return ResponseEntity.ok(itemService.getItemsByUserId(userId));
    }

    @GetMapping("/item")
    public ResponseEntity<Item> getItem(@RequestParam UUID itemId) {
        Optional<Item> item = itemService.getItemById(itemId);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/item/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item.getUserId(), item.getTitle(), item.getDescription()));
    }

    @PutMapping("/item/edit")
    public ResponseEntity<Item> editItem(@RequestBody Item item) {
        Optional<Item> editedItem = itemService.editItem(item.getId(), item.getUserId(), item.getTitle(), item.getDescription());
        return editedItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/item/delete")
    public ResponseEntity<String> deleteItem(@RequestParam UUID itemId) {
        itemService.deleteItemByItemId(itemId);
        return ResponseEntity.ok("Item successfully removed");
    }
}
