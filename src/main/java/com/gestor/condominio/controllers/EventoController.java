package com.gestor.condominio.controllers;


import com.gestor.condominio.models.Evento;
import com.gestor.condominio.services.EventoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/eventos")
@Api(value = "API REST Propig Data")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um evento")
    public ResponseEntity<Void> save (@RequestBody Evento evento){
        evento = eventoService.saveEvento(evento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Filtra por ID")
    public ResponseEntity<?> find(@PathVariable Long id){
        Evento evento = eventoService.findEvento(id);
        return  ResponseEntity.ok().body(evento);
    }

    @RequestMapping(value = "/data/{data}", method = RequestMethod.GET)
    @ApiOperation(value = "Filtra evento por data")
    public ResponseEntity<List<Evento>> findEventosByData(@PathVariable String data) {
        List<Evento> eventos = eventoService.getEventosByData(data);
        return ResponseEntity.ok().body(eventos);
    }

    @RequestMapping(value = "/tipo/{tipo}", method = RequestMethod.GET)
    @ApiOperation(value = "Filtra por tipo, como por exemplo: aniversário, formatura, festa genérica")
    public ResponseEntity<List<Evento>> findEventosByTipo(@PathVariable String tipo) {
        List<Evento> eventos = eventoService.getEventosByTipo(tipo);
        return ResponseEntity.ok().body(eventos);
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Update por ID")
    public ResponseEntity<Void> update(@RequestBody Evento evento, @PathVariable Long id){
        evento.setId(id);
        evento = eventoService.updateEvento(evento);
        return  ResponseEntity.ok().build();
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleção por ID")
    public ResponseEntity<?> delete(@PathVariable Long id){
        eventoService.deleteEvento(id);
        return  ResponseEntity.noContent().build();
    }
}
