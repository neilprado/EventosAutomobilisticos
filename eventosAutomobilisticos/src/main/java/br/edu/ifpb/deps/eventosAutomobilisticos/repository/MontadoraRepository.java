package br.edu.ifpb.deps.eventosAutomobilisticos.repository;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MontadoraRepository extends JpaRepository<Montadora, Long> {
}
