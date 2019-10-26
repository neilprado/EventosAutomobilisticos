package br.edu.ifpb.deps.eventosAutomobilisticos.dto.request;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Carro;
import lombok.Data;

import java.util.List;

@Data
public class MontadoraRequest {
    private String nome;
    private String pais;
    private List<Carro> carros;
}
