package com.devChallengue.WSClientes.repository;

import com.devChallengue.WSClientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends  JpaRepository<Client,Long> {

    Client findByClienteId(String cliente);


}
