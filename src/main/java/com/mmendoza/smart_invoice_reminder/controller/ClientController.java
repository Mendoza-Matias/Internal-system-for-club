package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{clientId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{clientId}/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateClientInfo(@PathVariable String clientId, @RequestBody Client client) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{clientId}/delete")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteClient(@PathVariable String clientId) {
        return ResponseEntity.ok().build();
    }
}

