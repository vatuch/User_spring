package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repositories.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = "id")
    public ResponseEntity<User> getUserById(@RequestParam int id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> getUserByJson(@RequestBody UserRequest userRequest) {
        User user = userService.getUser(userRequest.getId());
        return ResponseEntity.ok(user);
    }

    private static class UserRequest {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


}
