package org.studennikov.todolist.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.*;
import org.studennikov.todolist.model.User;
import org.studennikov.todolist.service.UserService;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "Welcome to the TODO LIST";
    }


    @GetMapping("/user/get/byName")
    public ResponseEntity<User> getUser(@RequestParam String userName) {
        Optional<User> user = userService.getUserByUserName(userName);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/get/current")
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) request.getUserPrincipal();
        DefaultOAuth2User userInfo = (DefaultOAuth2User) token.getPrincipal();
        String userName = userInfo.getAttributes().get("login").toString();
        log.info("User name : " + userName);
        Optional<User> user = userService.getUserByUserName(userName);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/get/byId")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(HttpServletRequest request) {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) request.getUserPrincipal();
        DefaultOAuth2User userInfo = (DefaultOAuth2User) token.getPrincipal();
        String userName = userInfo.getAttributes().get("login").toString();
        log.info("User name : " + userName);
        return ResponseEntity.ok(userService.addUser(userName));
    }

    @GetMapping("/user")
    public String userPage() {
        return "Welcome to the user page";
    }
}
