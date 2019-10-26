package br.edu.ifpb.deps.eventosAutomobilisticos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    private String pais;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Montadora> montadoras = new ArrayList<>();
    private LocalDateTime dataEvento;
    private BigDecimal ingressoValor;
}
