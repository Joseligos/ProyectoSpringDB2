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

import com.apirest.backend.Models.ParticipantesModel;
import com.apirest.backend.Repository.ParticipanteRepository;

@RestController
@RequestMapping("/participantes")
public class ParticipantesController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @GetMapping
    public List<ParticipantesModel> getAllParticipantesModel() {
        return participanteRepository.findAll();
    }

    @GetMapping("/buscarPorIdParticipante/{idParticipante}")
    public ResponseEntity<ParticipantesModel> getParticipanteByIdParticipante(@PathVariable Integer idParticipante) {
        Optional<ParticipantesModel> participante = participanteRepository.findByIdParticipante(idParticipante);
        return participante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ParticipantesModel> createParticipante(@RequestBody ParticipantesModel participante) {
        ParticipantesModel savedParticipante = participanteRepository.save(participante);
        return ResponseEntity.status(201).body(savedParticipante);
    }

    @PutMapping("/actualizarPorIdParticipante/{idParticipante}")
    public ResponseEntity<ParticipantesModel> updatePacienteByIdPaciente(@PathVariable Integer idParticipante, @RequestBody ParticipantesModel participanteDetails) {
        Optional<ParticipantesModel> participante = participanteRepository.findByIdParticipante(idParticipante);
        if (participante.isPresent()) {
            ParticipantesModel existingParticipante = participante.get();
            existingParticipante.setNombre(participanteDetails.getNombre());
            existingParticipante.setUniversidad(participanteDetails.getUniversidad());
            existingParticipante.setIdParticipante(participanteDetails.getIdParticipante());
            return ResponseEntity.ok(participanteRepository.save(existingParticipante));
        }
        return ResponseEntity.notFound().build();
    }

}
