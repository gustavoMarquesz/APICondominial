package com.gestor.condominio.services;


import com.gestor.condominio.exception.EventoNotFound;
import com.gestor.condominio.models.Evento;
import com.gestor.condominio.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public Evento saveEvento (Evento evento){
        eventoRepository.save(evento);
        return evento;
    }

    public Evento findEvento (Long id) throws EventoNotFound {
        Optional<Evento> evento = eventoRepository.findById(id);
        return  evento.orElseThrow(()-> new EventoNotFound());
    }

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public List<Evento> getEventosByTipo(String tipo) {
        return eventoRepository.findByTipo(tipo);
    }

    public List<Evento> getEventosByData(String data) {
        return eventoRepository.findByData(data);
    }

    public Evento updateEvento(Evento evento){
        findEvento(evento.getId());
        eventoRepository.save(evento);
        return  evento;
    }

    public  void deleteEvento(Long id){
        eventoRepository.deleteById(id);
    }
}
