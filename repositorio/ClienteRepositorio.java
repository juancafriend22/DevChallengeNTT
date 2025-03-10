package com.devChallengue.WSClientes.repository;

import com.devChallengue.WSClientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends  JpaRepository<Cliente,Long> {

    Cliente findByClienteId(String cliente);


}
