package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.dtos.ClientResponse;
import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientResponse toClientResponse(Client client) {
        return new ClientResponse(
                client.getName(),
                client.getLastName(),
                client.getEmail(),
                client.getTelephone(),
                client.getAddress()
        );
    }

    public List<ClientResponse> toClientResponseList(List<Client> clients) {
        return clients.stream().map(this::toClientResponse).collect(Collectors.toList());
    }
}
