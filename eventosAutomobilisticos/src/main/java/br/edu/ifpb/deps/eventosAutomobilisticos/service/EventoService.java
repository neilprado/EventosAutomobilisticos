package br.edu.ifpb.deps.eventosAutomobilisticos.service;

import br.edu.ifpb.deps.eventosAutomobilisticos.dto.request.EventoRequest;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Evento;
import br.edu.ifpb.deps.eventosAutomobilisticos.repository.EventoRepository;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criarEvento(EventoRequest request){
        Evento evento = new Evento();

        evento.setCidade(request.getCidade());
        evento.setDataEvento(request.getDataEvento());
        evento.setIngressoValor(request.getValor());
        evento.setNome(request.getNome());
        evento.setPais(request.getPais());

        return evento;
    }

    public Evento atualizarEvento(Long id, EventoRequest request){
        Evento evento = this.eventoRepository.findById(id).orElseThrow(
                () -> new HandlerException("Evento inexistente"));

        evento.setCidade(request.getCidade());
        evento.setDataEvento(request.getDataEvento());
        evento.setIngressoValor(request.getValor());
        evento.setNome(request.getNome());
        evento.setPais(request.getPais());

        return evento;
    }

    public Page<Evento> listarEventos(Pageable pageable){
        return this.eventoRepository.findAll(pageable);
    }

    public Evento buscarEvento(Long id){
        Evento evento = this.eventoRepository.findById(id).orElseThrow(
                () -> new HandlerException("Evento inexistente"));

        return evento;
    }

    public void removerEvento(Long id){
        Evento evento = this.eventoRepository.findById(id).orElseThrow(
                () -> new HandlerException("Evento inexistente"));
        this.eventoRepository.delete(evento);
    }
}
