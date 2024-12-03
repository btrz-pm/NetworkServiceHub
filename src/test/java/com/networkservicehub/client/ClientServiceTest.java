package com.networkservicehub.client;

import com.networkservicehub.client.domain.Client;
import com.networkservicehub.client.repository.ClientRepository;
import com.networkservicehub.client.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client(1L, "John Doe", "123654789", "John@email.com","5523698752");
    }

    @Test
    public void shouldCreateClient() {
        when(clientRepository.save(client)).thenReturn(client);
        Client createdClient = clientService.create(client);
        assertNotNull(createdClient);
        assertEquals("John Doe", createdClient.getName());
        assertEquals("123654789", createdClient.getDocument());
        assertEquals("John@email.com", createdClient.getEmail());
        assertEquals("5523698752", createdClient.getPhone());
    }
    @Test
    public void testGetClientById() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Optional<Client> foundClient = clientService.findById(1L);
        assertTrue(foundClient.isPresent());
        assertEquals("John Doe", foundClient.get().getName());
    }
    @Test
    public void testUpdateClient() {
        when(clientRepository.existsById(1L)).thenReturn(true);
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        Client updatedClient = clientService.update(1L, client);
        assertNotNull(updatedClient);
        assertEquals("John Doe", updatedClient.getName());
    }
    @Test
    public void testDeleteClient() {
        doNothing().when(clientRepository).deleteById(1L);
        clientService.delete(1L);
        verify(clientRepository, times(1)).deleteById(1L);
    }
}
