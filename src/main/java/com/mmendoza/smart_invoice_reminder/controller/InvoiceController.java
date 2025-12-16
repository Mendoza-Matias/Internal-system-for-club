package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {


    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllMyInvoices() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createInvoice() {
        return ResponseEntity.ok().build();
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

