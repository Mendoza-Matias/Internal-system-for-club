package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.UpdateClientInformation;
import com.mmendoza.smart_invoice_reminder.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createClient(@RequestBody CreateClientRequest request) {
        clientService.createClient(request);
        return ResponseEntity.created(URI.create("/api/v1/clients")).build();
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

