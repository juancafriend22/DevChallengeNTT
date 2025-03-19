package service;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.exception.ClientNotFoundException;
import com.devChallengue.WSClientes.mapper.ClientEntityMapper;
import com.devChallengue.WSClientes.model.Client;
import com.devChallengue.WSClientes.repository.ClientRepository;
import com.devChallengue.WSClientes.service.impl.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

        @Mock
        private ClientRepository clientRepository;

        @InjectMocks
        private ClientService clientService;

        private Client client;
        private ClientDTO clientDTO;

        @BeforeEach
        void setUp() {
            client = new Client();
            client.setId(13131313L);
            client.setNombre("John Doe");
            client.setClienteId("12345");
            client.setContrasena("password");
            client.setEstado(true);
            client.setTelefono("0960048580");
            client.setDireccion("La gasca");
            client.setClienteId("C13131313");
            client.setContrasena("password");
            client.setEdad(23);
            client.setGenero("Masculino");

            clientDTO = ClientEntityMapper.toDTO(client);
        }

        @Test
        void testCrearClienteSuccess() {
            when(clientRepository.save(any(Client.class))).thenReturn(client);

            ClientDTO result = clientService.crearCliente(clientDTO);

            assertNotNull(result);
            assertEquals(clientDTO.getNombre(), result.getNombre());
            verify(clientRepository, times(1)).save(any(Client.class));
        }

        @Test
        void testObtenerClientePorIdSuccess() {
            when(clientRepository.findById(13131313L)).thenReturn(Optional.of(client));

            ClientDTO result = clientService.obtenerClientePorId(13131313L);

            assertNotNull(result);
            assertEquals(clientDTO.getNombre(), result.getNombre());
            verify(clientRepository, times(1)).findById(13131313L);
        }

        @Test
        void testObtenerClientePorIdNotFound() {
            when(clientRepository.findById(13131313L)).thenReturn(Optional.empty());

            assertThrows(ClientNotFoundException.class, () -> clientService.obtenerClientePorId(13131313L));
            verify(clientRepository, times(1)).findById(13131313L);
        }

        @Test
        void testEliminarClienteSuccess() {
            when(clientRepository.existsById(13131313L)).thenReturn(true);

            boolean result = clientService.eliminarCliente(13131313L);

            assertTrue(result);
            verify(clientRepository, times(1)).deleteById(13131313L);
        }

        @Test
        void testEliminarClienteNotFound() {
            when(clientRepository.existsById(13131313L)).thenReturn(false);

            assertThrows(ClientNotFoundException.class, () -> clientService.eliminarCliente(13131313L));
            verify(clientRepository, times(0)).deleteById(13131313L);
        }
}


