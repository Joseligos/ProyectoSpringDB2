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

import com.apirest.backend.NeoM.participantesModel;
import com.apirest.backend.NeoR.participanteNeoRepository;

@RestController
@RequestMapping("/participantesNeo")
public class participantesNeoController {

    @Autowired
    private participanteNeoRepository participanteNeoRepository;

    @GetMapping
    public List<participantesModel> getAllParticipantes() {
        return participanteNeoRepository.findAll();
    }

    @GetMapping("/buscarPorIdParticipante/{idParticipante}")
    public ResponseEntity<participantesModel> getParticipanteById(@PathVariable String idParticipante) {
        Optional<participantesModel> participante = participanteNeoRepository.findById(idParticipante);
        return participante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<participantesModel> createEvento(@RequestBody participantesModel nuevoParticipante) {
        participantesModel savedParticipante = participanteNeoRepository.save(nuevoParticipante);
        return ResponseEntity.status(201).body(savedParticipante);
    }

    @PutMapping("/actualizarPorIdParticipante/{idParticipante}")
    public ResponseEntity<participantesModel> updateParticipanteById(@PathVariable String idParticipante, @RequestBody participantesModel participanteDetails) {
        Optional<participantesModel> participante = participanteNeoRepository.findById(idParticipante);
        if (participante.isPresent()) {
            participantesModel existingParticipante = participante.get();
            existingParticipante.setNombreC(participanteDetails.getNombreC());
            existingParticipante.setUniversidadC(participanteDetails.getUniversidadC());
            return ResponseEntity.ok(participanteNeoRepository.save(existingParticipante));
        }
        return ResponseEntity.notFound().build();
    }

}
