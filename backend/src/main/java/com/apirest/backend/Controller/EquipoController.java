package com.apirest.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Models.EquipoModel;
import com.apirest.backend.Repository.EquipoRepository;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    @GetMapping
    public List<EquipoModel> getAllEquiposModel() {
        return equipoRepository.findAll();
    }

    @GetMapping("/buscarPorIdEquipo/{idEquipo}")
    public ResponseEntity<EquipoModel> getEquipoByIdEquipo(@PathVariable Integer idEquipo) {
        Optional<EquipoModel> equipo = equipoRepository.findByIdEquipo(idEquipo);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EquipoModel> equipoRepository(@RequestBody EquipoModel equipo) {
        EquipoModel savedEquipo = equipoRepository.save(equipo);
        return ResponseEntity.status(201).body(savedEquipo);
    }

    @PutMapping("/actualizarPorIdEquipo/{idEquipo}")
    public ResponseEntity<EquipoModel> updateEquipoByIdEquipo(@PathVariable Integer idEquipo, @RequestBody EquipoModel equipoDetails) {
        Optional<EquipoModel> equipo = equipoRepository.findByIdEquipo(idEquipo);
        if (equipo.isPresent()) {
            EquipoModel existingEquipo = equipo.get();
            existingEquipo.setIdEquipo(equipoDetails.getIdEquipo());
            existingEquipo.setNombre(equipoDetails.getNombre());
            existingEquipo.setCategoria(equipoDetails.getCategoria());
            existingEquipo.setIdEventos(equipoDetails.getIdEventos());
            existingEquipo.setIdParticipantes(equipoDetails.getIdParticipantes());
            existingEquipo.setEventosGanados(equipoDetails.getEventosGanados());
            return ResponseEntity.ok(equipoRepository.save(existingEquipo));
        }
        return ResponseEntity.notFound().build();
    }

}
