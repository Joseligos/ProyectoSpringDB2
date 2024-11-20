package com.apirest.backend.NeoR;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.NeoM.eventosModel;

@Repository
public interface eventoNeoRepository extends Neo4jRepository<eventosModel, String> {

}
