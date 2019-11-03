package br.edu.ifpb.deps.eventosAutomobilisticos.model;

import lombok.Data;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String pais;

    @ManyToMany
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_evento_usuario_id"))
    private Usuario usuario;

    @ManyToMany
    @JoinColumn(name = "montadora_id", nullable = false, foreignKey = @ForeignKey(name = "fk_montadora_usuario_id"))
    private Montadora montadora;

    @Column(nullable = false)
    private LocalDateTime dataEvento;

    @Column(nullable = false)
    private BigDecimal ingressoValor;
}
