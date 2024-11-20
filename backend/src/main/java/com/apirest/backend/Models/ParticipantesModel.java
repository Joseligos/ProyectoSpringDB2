package com.apirest.backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Participantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantesModel {

    @Id
    private String id;
    private String idParticipante;
    private String nombre;
    private String universidad;

}
