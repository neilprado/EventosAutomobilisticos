package br.edu.ifpb.deps.eventosAutomobilisticos.dto.request;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Usuario;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventoRequest {
    private String nome;
    private String cidade;
    private String pais;
    private List<Usuario> usuarios;
    private List<Montadora> montadoras;
    private LocalDateTime dataEvento;
    private BigDecimal valor;
}
