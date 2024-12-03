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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
        Client createdClient = clientService.createClient(client);
        assertNotNull(createdClient);
        assertEquals("John Doe", createdClient.getName());
        assertEquals("123654789", createdClient.getDocument());
        assertEquals("John@email.com", createdClient.getEmail());
        assertEquals("5523698752", createdClient.getPhone());
    }
}
