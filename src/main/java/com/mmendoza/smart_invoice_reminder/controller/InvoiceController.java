package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    @GetMapping
    public ResponseEntity<?> getAllMyInvoices() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<?> getInvoice(@PathVariable("invoiceId") String invoiceId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{invoice}/update")
    public ResponseEntity<?> updateInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{invoice}/delete")
    public ResponseEntity<?> deleteInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok().build();
    }
}
