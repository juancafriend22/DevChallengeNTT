package com.devChallengue.WSClientes.controlador;

import com.devChallengue.WSClientes.dto.ClienteResponseDTO;
import com.devChallengue.WSClientes.dto.ClienteRequestDTO;
import com.devChallengue.WSClientes.mapper.ClienteRequestMapper;
import com.devChallengue.WSClientes.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private final ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
      }

    // POST: Crear cliente
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crearCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        // Transformar ClienteRequestDTO a ClienteDTO
        ClienteResponseDTO clienteResponseDTO = ClienteRequestMapper.toClienteDTO(clienteRequestDTO);
        ClienteResponseDTO clienteCreado = clienteServicio.crearCliente(clienteResponseDTO);
        return ResponseEntity.ok(clienteCreado);
    }

    // GET: Obtener un cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerCliente(@PathVariable Long id) {
        ClienteResponseDTO clienteResponseDTO = clienteServicio.obtenerClientePorId(id);
        return ResponseEntity.ok(clienteResponseDTO);
    }

    // GET: Obtener lista de todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> obtenerClientes() {
        List<ClienteResponseDTO> clientesDTO = clienteServicio.obtenerTodosClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    // DELETE: Eliminar un cliente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
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
