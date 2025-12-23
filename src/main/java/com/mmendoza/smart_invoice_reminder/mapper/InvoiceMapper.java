package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateInvoiceForAnClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import com.mmendoza.smart_invoice_reminder.domain.enums.InvoiceStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InvoiceMapper {

    private static final LocalDate CURRENT_DATE = LocalDate.now();
    private static final InvoiceStatus DEFAULT_INVOICE_STATUS = InvoiceStatus.PENDING;

    public Invoice toInvoice(CreateInvoiceForAnClientRequest request, Client client) {
        return Invoice.builder()
                .title(request.title())
                .description(request.description())
                .price(request.price())
                .createDate(CURRENT_DATE)
                .status(DEFAULT_INVOICE_STATUS)
                .paymentDeadline(request.paymentDeadline())
                .client(client)
                .build();
    }

}
