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
    public ResponseEntity<?> createInvoice() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<?> updateInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<?> deleteInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok().build();
    }
}

