package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import com.mmendoza.smart_invoice_reminder.mapper.ClientMapper;
import com.mmendoza.smart_invoice_reminder.repository.ClientRepository;
import com.mmendoza.smart_invoice_reminder.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientMapper.toClientResponseList(clientRepository.findAll());
    }

    @Override
    public void createClient(CreateClientRequest request) {

        Client client = Client.builder()
                .name(request.name())
                .lastName(request.lastName())
                .email(request.email())
                .telephone(request.telephone())
                .address(request.address())
                .build();

        clientRepository.save(client);
    }
}
