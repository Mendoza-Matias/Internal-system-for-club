package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.UpdateClientInformation;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createClient(@RequestBody CreateClientRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{clientId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{clientId}/information")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateClientInformation(@PathVariable Long clientId, @RequestBody UpdateClientInformation request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return ResponseEntity.ok().build();
    }
}

