package com.apirest.backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventosModel {

    @Id
    private String id;
    private Integer idEvento;
    private String alcance;
    private String pais;
    private String ciudad;
    private String fecha;
    private String lugar;
    private String nombre;

}
