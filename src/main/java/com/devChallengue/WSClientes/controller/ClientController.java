package com.devChallengue.WSClientes.controller;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.dto.ClientRequestDTO;
import com.devChallengue.WSClientes.mapper.ClientRequestMapper;
import com.devChallengue.WSClientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
      }

    // POST: Crear cliente
    @PostMapping
    public ResponseEntity<ClientDTO> crearCliente(@RequestBody ClientRequestDTO clientRequestDTO) {
        // Transformar ClienteRequestDTO a ClienteDTO
        ClientDTO clientDTO = ClientRequestMapper.toClienteDTO(clientRequestDTO);
        ClientDTO clienteCreado = clientService.crearCliente(clientDTO);
        return ResponseEntity.ok(clienteCreado);
    }

    // GET: Obtener un cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> obtenerCliente(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.obtenerClientePorId(id);
        return ResponseEntity.ok(clientDTO);
    }

    // GET: Obtener lista de todos los clientes
    @GetMapping
    public ResponseEntity<List<ClientDTO>> obtenerClientes() {
        List<ClientDTO> clientesDTO = clientService.obtenerTodosClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    // DELETE: Eliminar un cliente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clientService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

//    public ClienteControlador(ClienteServicio clienteServicio) {
//        this.clienteServicio = clienteServicio;
//    }
//
//    @GetMapping
//    public List<Cliente> obtenerClientes(){
//        return clienteServicio.obtenerTodos();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> obtenerCliente (@PathVariable Long id){
//        Optional<Cliente> cliente = clienteServicio.obtenerPorId(id);
//        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/buscar/{clienteId}")
//    public ResponseEntity<Cliente> obtenerClientePorClienteId(@PathVariable String clienteId) {
//        Cliente cliente = clienteServicio.obtenerClientePorClienteId(clienteId);
//        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public Cliente crearCliente(@RequestBody Cliente cliente){
//
//        return clienteServicio.guardar(cliente);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
//        clienteServicio.eliminarPorId(id);
//        return ResponseEntity.noContent().build();
//    }

}
