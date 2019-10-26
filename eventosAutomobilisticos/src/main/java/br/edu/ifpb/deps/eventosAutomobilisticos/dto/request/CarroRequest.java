package br.edu.ifpb.deps.eventosAutomobilisticos.dto.request;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarroRequest {
    private String nome;
    private int ano;
    private BigDecimal valor;
    private Montadora montadora;
}
