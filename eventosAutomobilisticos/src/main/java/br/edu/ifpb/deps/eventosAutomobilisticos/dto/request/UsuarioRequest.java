package br.edu.ifpb.deps.eventosAutomobilisticos.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioRequest {
    private String nome;
    private Date dataNascimento;
    private String email;
}
