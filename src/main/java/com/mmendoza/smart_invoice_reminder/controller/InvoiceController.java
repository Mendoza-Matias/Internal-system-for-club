package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateInvoiceForAnClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import com.mmendoza.smart_invoice_reminder.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllMyInvoices() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createInvoiceForAnClient(@RequestBody CreateInvoiceForAnClientRequest request) {
        invoiceService.createInvoiceForAnClient(request);
        return ResponseEntity.created(URI.create("/api/v1/invoices")).build();
    }

    @GetMapping("/{invoiceId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getInvoiceById(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{invoiceId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{invoiceId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }
}

