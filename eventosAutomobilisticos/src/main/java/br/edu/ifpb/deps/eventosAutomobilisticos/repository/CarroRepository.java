package br.edu.ifpb.deps.eventosAutomobilisticos.repository;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
