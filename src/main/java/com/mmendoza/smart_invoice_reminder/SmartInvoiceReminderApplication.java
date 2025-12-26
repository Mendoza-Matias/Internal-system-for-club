package com.mmendoza.smart_invoice_reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartInvoiceReminderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartInvoiceReminderApplication.class, args);
    }

}
