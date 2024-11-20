package com.apirest.backend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.Models.EquipoModel;

@Repository
public interface EquipoRepository extends MongoRepository<EquipoModel, String> {

    Optional<EquipoModel> findByIdEquipo(Integer idEquipo);

}
