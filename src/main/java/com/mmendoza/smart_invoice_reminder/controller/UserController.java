package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/info")
    public ResponseEntity<?> getUserInfo(@PathVariable String userId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/update")
    @PreAuthorize("hasAllRoles('USER','ADMIN')")
    public ResponseEntity<?> updateUserInfo(@PathVariable String userId, @RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
