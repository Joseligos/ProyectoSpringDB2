package com.apirest.backend.NeoM;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class eventosModel {

    @Id
    private String idEvento;
    private String alcanceC;
    private String paisC;
    private String ciudadC;
    private String fechaC;
    private String lugarC;
    private String nombreC;

    @Relationship(type = "Participa", direction = Relationship.Direction.INCOMING)
    private Set<equipoModel> equipoModel;
}
