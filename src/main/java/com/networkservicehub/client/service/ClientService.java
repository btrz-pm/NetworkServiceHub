package com.networkservicehub.client.service;

import com.networkservicehub.client.domain.Client;
import com.networkservicehub.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
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
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
