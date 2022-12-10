package com.sprint.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sprint.crud.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
   