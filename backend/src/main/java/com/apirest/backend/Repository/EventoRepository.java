package com.apirest.backend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.Models.EventosModel;

@Repository
public interface EventoRepository extends MongoRepository<EventosModel, String> {

    Optional<EventosModel> findByIdEvento(Integer idEvento);

}
