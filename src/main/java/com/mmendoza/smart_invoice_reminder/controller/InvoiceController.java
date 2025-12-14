package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {


    @GetMapping
    public ResponseEntity<?> getAllMyInvoices() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createInvoice(
    ) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoice(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInvoice(
            @PathVariable String id
    ) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}

