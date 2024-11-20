package com.apirest.backend.NeoM;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class equipoModel {

    @Id
    private String idEquipo;
    private String nombreC;
    private String categoriaC;
    private Integer eventosGanadosC;

    @Relationship(type = "Tiene", direction = Relationship.Direction.INCOMING)
    private participantesModel participante;

    @Relationship(type = "Participa", direction = Relationship.Direction.OUTGOING)
    private eventosModel evento;

}
