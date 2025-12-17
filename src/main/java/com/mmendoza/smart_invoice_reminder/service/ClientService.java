package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;

import java.util.List;

public interface ClientService {
    List<ClientResponse> getAllClients();
    void createClient(CreateClientRequest request);
}
