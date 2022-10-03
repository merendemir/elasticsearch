package com.web.elasticsearch.controller;

import com.web.elasticsearch.dto.UserDtoRequest;
import com.web.elasticsearch.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveUser(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(userService.createAndSaveUser(userDtoRequest));
    }

    @GetMapping("/by_id")
    public ResponseEntity<Object> findUser(@RequestParam String userId) {
        return ResponseEntity.ok(userService.findUser(userId));
    }

    @GetMapping("/by_name")
    public ResponseEntity<Object> findUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.findUserByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping("/update")
    public ResponseEntity<Object> findUser(@RequestParam String userId,
                                           @RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(userService.updateUser(userId, userDtoRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam String userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Object> deleteAllUser() {
        userService.deleteAllUser();
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }


}
