package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateInvoiceForAnClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import com.mmendoza.smart_invoice_reminder.mapper.ClientMapper;
import com.mmendoza.smart_invoice_reminder.mapper.InvoiceMapper;
import com.mmendoza.smart_invoice_reminder.repository.InvoiceRepository;
import com.mmendoza.smart_invoice_reminder.service.ClientService;
import com.mmendoza.smart_invoice_reminder.service.InvoiceService;
import com.mmendoza.smart_invoice_reminder.validator.CreateInvoiceForAnClientValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientService clientService;
    private final InvoiceMapper invoiceMapper;
    private final CreateInvoiceForAnClientValidator createInvoiceForAnClientValidator;
    private final ClientMapper clientMapper;


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ClientService clientService, InvoiceMapper invoiceMapper, CreateInvoiceForAnClientValidator createInvoiceForAnClientValidator, ClientMapper clientMapper) {
        this.invoiceRepository = invoiceRepository;
        this.clientService = clientService;
        this.invoiceMapper = invoiceMapper;
        this.createInvoiceForAnClientValidator = createInvoiceForAnClientValidator;
        this.clientMapper = clientMapper;
    }

    @Override
    public void createInvoiceForAnClient(CreateInvoiceForAnClientRequest request) {

        Client existingClient = clientMapper.toClient(clientService.getClientById(request.clientId()));

        createInvoiceForAnClientValidator.validate(request);

        Invoice newInvoice = invoiceMapper.toInvoice(request, existingClient);

        invoiceRepository.save(newInvoice);
    }

    @Override
    public List<Invoice> getAllUnpaidInvoices(LocalDate date) {
        return invoiceRepository.getAllUnpaidInvoicesWithOneWeekDue(date);
    }

    @Override
    public void markReminderSent(Long invoiceId) {
        invoiceRepository.markReminderSent(invoiceId);
    }
}
