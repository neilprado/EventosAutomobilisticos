package br.edu.ifpb.deps.eventosAutomobilisticos.dto.response;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Usuario;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;

@Data
public class UsuarioResponse {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String email;

    public static UsuarioResponse from(Usuario usuario){
        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setDataNascimento(usuario.getDataNascimento());
        usuarioResponse.setEmail(usuario.getEmail());
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setNome(usuario.getNome());

        return usuarioResponse;
    }

    public static Page<UsuarioResponse> from(Page<Usuario> usuarios){
        Page<UsuarioResponse> usuarioResponses = usuarios.map(usuario -> {
            UsuarioResponse usuarioResponse = new UsuarioResponse();

            usuarioResponse.setDataNascimento(usuario.getDataNascimento());
            usuarioResponse.setEmail(usuario.getEmail());
            usuarioResponse.setId(usuario.getId());
            usuarioResponse.setNome(usuario.getNome());

            return usuarioResponse;
        });
        return usuarioResponses;
    }
}
