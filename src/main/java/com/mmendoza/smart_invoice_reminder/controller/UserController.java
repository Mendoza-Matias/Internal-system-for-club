package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/information")
    public ResponseEntity<?> getUserInformation(@PathVariable String userId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/information")
    @PreAuthorize("hasAllRoles('USER','ADMIN')")
    public ResponseEntity<?> updateUserInformation(@PathVariable String userId, @RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
