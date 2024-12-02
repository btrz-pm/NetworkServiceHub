package com.networkservicehub.client.service;

import com.networkservicehub.client.domain.Client;
import com.networkservicehub.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    public Client create(Client client) {
        return clientRepository.save(client);
    }
    public Client update(Long id, Client updatedClient) {
        if (clientRepository.existsById(id)) {
            updatedClient.setId(id);
            return clientRepository.save(updatedClient);
        }
        return null;
    }
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
