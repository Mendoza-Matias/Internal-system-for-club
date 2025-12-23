package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientResponse toClientResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getEmail(),
                client.getTelephone(),
                client.getAddress()
        );
    }

    public Client toClient(ClientResponse clientResponse) {
        return Client.builder()
                .id(clientResponse.clientId())
                .name(clientResponse.name())
                .lastName(clientResponse.lastName())
                .email(clientResponse.email())
                .telephone(clientResponse.telephone())
                .address(clientResponse.address())
                .build();
    }

    public Client toClient(CreateClientRequest createClientRequest) {
        return Client.builder()
                .name(createClientRequest.name())
                .lastName(createClientRequest.lastName())
                .email(createClientRequest.email())
                .telephone(createClientRequest.telephone())
                .address(createClientRequest.address())
                .build();
    }

    public List<ClientResponse> toClientResponseList(List<Client> clients) {
        return clients.stream().map(this::toClientResponse).collect(Collectors.toList());
    }
}
