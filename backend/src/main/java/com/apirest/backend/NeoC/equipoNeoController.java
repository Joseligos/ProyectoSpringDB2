package com.apirest.backend.NeoC;

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

import com.apirest.backend.NeoM.equipoModel;
import com.apirest.backend.NeoR.equipoNeoRepository;

@RestController
@RequestMapping("/equipoNeo")
public class equipoNeoController {

    @Autowired
    private equipoNeoRepository equipoNeoRepository;

    @GetMapping
    public List<equipoModel> getAllEquipos() {
        return equipoNeoRepository.findAll();
    }

    @GetMapping("/buscarPorIdEquipo/{idEquipo}")
    public ResponseEntity<equipoModel> getEquipoById(@PathVariable String idEquipo) {
        Optional<equipoModel> equipo = equipoNeoRepository.findById(idEquipo);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<equipoModel> createEquipo(@RequestBody equipoModel nuevoEquipo) {
        equipoModel savedEquipo = equipoNeoRepository.save(nuevoEquipo);
        return ResponseEntity.status(201).body(savedEquipo);
    }

    @PutMapping("/actualizarPorIdEquipo/{idEquipo}")
    public ResponseEntity<equipoModel> updateEquipoById(@PathVariable String idEquipo, @RequestBody equipoModel equipoDetails) {
        Optional<equipoModel> equipo = equipoNeoRepository.findById(idEquipo);
        if (equipo.isPresent()) {
            equipoModel existingEquipo = equipo.get();
            existingEquipo.setNombreC(equipoDetails.getNombreC());
            existingEquipo.setCategoriaC(equipoDetails.getCategoriaC());
            existingEquipo.setEventosGanadosC(equipoDetails.getEventosGanadosC());
            return ResponseEntity.ok(equipoNeoRepository.save(existingEquipo));
        }
        return ResponseEntity.notFound().build();
    }

}
