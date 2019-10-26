package br.edu.ifpb.deps.eventosAutomobilisticos.repository;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
