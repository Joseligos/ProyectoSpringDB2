package com.apirest.backend.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Equipo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoModel {

    @Id
    private String id;
    private Integer idEquipo;
    private String nombre;
    private String categoria;
    private List<String> idEventos;
    private List<String> idParticipantes;
    private Integer eventosGanados;

}
