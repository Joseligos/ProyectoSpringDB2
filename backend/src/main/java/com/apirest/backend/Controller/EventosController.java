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

import com.apirest.backend.Models.EventosModel;
import com.apirest.backend.Repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<EventosModel> getAllEventosModel() {
        return eventoRepository.findAll();
    }

    @GetMapping("/buscarPorIdEvento/{idEvento}")
    public ResponseEntity<EventosModel> getParticipanteByIdParticipante(@PathVariable Integer idEvento) {
        Optional<EventosModel> evento = eventoRepository.findByIdEvento(idEvento);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventosModel> createParticipante(@RequestBody EventosModel evento) {
        EventosModel savedEvento = eventoRepository.save(evento);
        return ResponseEntity.status(201).body(savedEvento);
    }

    @PutMapping("/actualizarPorIdEvento/{idEvento}")
    public ResponseEntity<EventosModel> updateEventoByIdEvento(@PathVariable Integer idEvento, @RequestBody EventosModel eventoDetails) {
        Optional<EventosModel> evento = eventoRepository.findByIdEvento(idEvento);
        if (evento.isPresent()) {
            EventosModel existingEvento = evento.get();
            existingEvento.setIdEvento(eventoDetails.getIdEvento());
            existingEvento.setAlcance(eventoDetails.getAlcance());
            existingEvento.setPais(eventoDetails.getPais());
            existingEvento.setCiudad(eventoDetails.getCiudad());
            existingEvento.setFecha(eventoDetails.getFecha());
            existingEvento.setLugar(eventoDetails.getLugar());
            existingEvento.setNombre(eventoDetails.getNombre());
            return ResponseEntity.ok(eventoRepository.save(existingEvento));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crearEvento")
    public ResponseEntity<EventosModel> crearEvento(@RequestBody EventosModel evento) {
        EventosModel savedEvento = eventoRepository.save(evento);
        return ResponseEntity.status(201).body(savedEvento);
    }

}
