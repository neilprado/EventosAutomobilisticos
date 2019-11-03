package br.edu.ifpb.deps.eventosAutomobilisticos.service;

import br.edu.ifpb.deps.eventosAutomobilisticos.dto.request.UsuarioRequest;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Usuario;
import br.edu.ifpb.deps.eventosAutomobilisticos.repository.UsuarioRepository;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(UsuarioRequest request){
        Usuario usuario = this.usuarioRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new HandlerException("Email já cadastrado na base de dados"));

        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setEmail(request.getEmail());
        usuario.setNome(request.getNome());
        usuario.setSenha(request.getSenha()); // -- Criptografar a senha --

        return usuario;
    }

    public Usuario atualizarUsuario(Long id, UsuarioRequest request){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new HandlerException("Usuário inexistente"));

        Optional<Usuario> busca = this.usuarioRepository.findByEmail(request.getEmail());

        if(!busca.isPresent()) {
            usuario.setEmail(request.getEmail()); // -- Buscar caso estejam diferentes o email --
        }

        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setNome(request.getNome());
        usuario.setSenha(request.getSenha()); // -- Criptografar a senha --

        return usuario;
    }

    public Page<Usuario> listarUsuarios(Pageable pageable){
        return this.usuarioRepository.findAll(pageable);
    }

    public Usuario buscarUsuario(Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new HandlerException("Usuário inexistente"));
        return usuario;
    }

    public void removerUsuario(Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new HandlerException("Usuário inexistente"));
        this.usuarioRepository.delete(usuario);
    }
}
