package br.edu.ifpb.deps.eventosAutomobilisticos.repository;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
