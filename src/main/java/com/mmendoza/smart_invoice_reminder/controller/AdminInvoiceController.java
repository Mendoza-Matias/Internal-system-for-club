package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/invoice")
public class AdminInvoiceController {

    @GetMapping
    public ResponseEntity<?> getAllInvoice() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/overdue")
    public ResponseEntity<?> getAllOverdueInvoices() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reminder")
    public ResponseEntity<?> sendMassiveReminder(@RequestBody List<Invoice> invoices) {
        return ResponseEntity.ok().build();
    }

}
