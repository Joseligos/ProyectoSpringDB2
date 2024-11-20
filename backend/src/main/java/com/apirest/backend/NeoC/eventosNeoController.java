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

import com.apirest.backend.NeoM.eventosModel;
import com.apirest.backend.NeoR.eventoNeoRepository;

@RestController
@RequestMapping("/eventoNeo")
public class eventosNeoController {

    @Autowired
    private eventoNeoRepository eventoNeoRepository;

    @GetMapping
    public List<eventosModel> getAllEventos() {
        return eventoNeoRepository.findAll();
    }

    @GetMapping("/buscarPorIdEvento/{idEvento}")
    public ResponseEntity<eventosModel> getEquipoById(@PathVariable String idEvento) {
        Optional<eventosModel> evento = eventoNeoRepository.findById(idEvento);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<eventosModel> createEvento(@RequestBody eventosModel nuevoEvento) {
        eventosModel savedEvento = eventoNeoRepository.save(nuevoEvento);
        return ResponseEntity.status(201).body(savedEvento);
    }

    @PutMapping("/actualizarPorIdEvento/{idEvento}")
    public ResponseEntity<eventosModel> updateEquipoById(@PathVariable String idEvento, @RequestBody eventosModel eventoDetails) {
        Optional<eventosModel> evento = eventoNeoRepository.findById(idEvento);
        if (evento.isPresent()) {
            eventosModel existingEvento = evento.get();
            existingEvento.setAlcanceC(eventoDetails.getAlcanceC());
            existingEvento.setPaisC(eventoDetails.getPaisC());
            existingEvento.setCiudadC(eventoDetails.getCiudadC());
            existingEvento.setFechaC(eventoDetails.getFechaC());
            existingEvento.setLugarC(eventoDetails.getLugarC());
            existingEvento.setNombreC(eventoDetails.getNombreC());
            return ResponseEntity.ok(eventoNeoRepository.save(existingEvento));
        }
        return ResponseEntity.notFound().build();
    }

}
