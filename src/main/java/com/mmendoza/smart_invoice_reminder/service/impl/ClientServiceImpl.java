package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import com.mmendoza.smart_invoice_reminder.mapper.ClientMapper;
import com.mmendoza.smart_invoice_reminder.repository.ClientRepository;
import com.mmendoza.smart_invoice_reminder.service.ClientService;
import com.mmendoza.smart_invoice_reminder.validator.CreateClientRequestValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private CreateClientRequestValidator createClientRequestValidator;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientMapper.toClientResponseList(clientRepository.findAll());
    }

    @Override
    public ClientResponse getClientById(Long clientId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ClientError.CLIENT_NOT_FOUND.getMessage()));

        return clientMapper.toClientResponse(client);
    }

    @Override
    public void createClient(CreateClientRequest request) {

        createClientRequestValidator.validate(request);

        Client newClient = clientMapper.toClient(request);

        clientRepository.save(newClient);
    }
}
