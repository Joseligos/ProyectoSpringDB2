package com.apirest.backend.NeoR;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.NeoM.equipoModel;

@Repository
public interface equipoNeoRepository extends Neo4jRepository<equipoModel, String> {

}
