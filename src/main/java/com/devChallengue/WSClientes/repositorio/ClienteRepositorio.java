package com.devChallengue.WSClientes.repositorio;

import com.devChallengue.WSClientes.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends  JpaRepository<Cliente,Long> {

    Cliente findByClienteId(String cliente);


}
