package br.edu.ifpb.deps.eventosAutomobilisticos.dto.response;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Evento;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EventoResponse {
    private Long id;
    private String nome;
    private String cidade;
    private String pais;
    private Long usuarioId;
    private Long montadoraId;
    private LocalDateTime dataEvento;
    private BigDecimal ingressoValor;

    public static EventoResponse from(Evento evento){
        EventoResponse eventoResponse = new EventoResponse();

        eventoResponse.setCidade(evento.getCidade());
        eventoResponse.setDataEvento(evento.getDataEvento());
        eventoResponse.setId(evento.getId());
        eventoResponse.setIngressoValor(evento.getIngressoValor());
        eventoResponse.setMontadoraId(evento.getMontadoras().get().getId());
        eventoResponse.setNome(evento.getNome());
        eventoResponse.setPais(evento.getPais());
        eventoResponse.setUsuarioId(evento.getUsuarios().get().getId());

        return eventoResponse;
    }

    public static Page<EventoResponse> from(Page<Evento> eventos){
        Page<EventoResponse> eventoResponses = eventos.map(evento -> {
            EventoResponse eventoResponse = new EventoResponse();

            eventoResponse.setCidade(evento.getCidade());
            eventoResponse.setDataEvento(evento.getDataEvento());
            eventoResponse.setId(evento.getId());
            eventoResponse.setIngressoValor(evento.getIngressoValor());
            eventoResponse.setMontadoraId(evento.getMontadoras().get().getId());
            eventoResponse.setNome(evento.getNome());
            eventoResponse.setPais(evento.getPais());
            eventoResponse.setUsuarioId(evento.getUsuarios().get().getId());

            return eventoResponse;
        });

        return eventoResponses;
    }
}
