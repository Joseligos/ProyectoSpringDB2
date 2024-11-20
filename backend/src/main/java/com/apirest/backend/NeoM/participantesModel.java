package com.apirest.backend.NeoM;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class participantesModel {

    @Id
    private Long idParticipante;
    private String nombreC;
    private String universidadC;

}
