package com.apirest.backend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.Models.ParticipantesModel;

@Repository
public interface ParticipanteRepository extends MongoRepository<ParticipantesModel, String> {

    Optional<ParticipantesModel> findByIdParticipante(Integer idParticipante);

}
