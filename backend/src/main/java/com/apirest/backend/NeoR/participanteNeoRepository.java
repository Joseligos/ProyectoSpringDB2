package com.apirest.backend.NeoR;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.NeoM.participantesModel;

@Repository
public interface participanteNeoRepository extends Neo4jRepository<participantesModel, String> {

}
