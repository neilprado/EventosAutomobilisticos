package br.edu.ifpb.deps.eventosAutomobilisticos.service;

import br.edu.ifpb.deps.eventosAutomobilisticos.dto.request.MontadoraRequest;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import br.edu.ifpb.deps.eventosAutomobilisticos.repository.MontadoraRepository;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MontadoraService {
    private final MontadoraRepository montadoraRepository;

    public MontadoraService(MontadoraRepository montadoraRepository) {
        this.montadoraRepository = montadoraRepository;
    }

    public Montadora criarMontadora(MontadoraRequest request){
        Montadora montadora = new Montadora();

        montadora.setNome(request.getNome());
        montadora.setPais(request.getPais());

        return this.montadoraRepository.save(montadora);
    }

    public Montadora atualizarMontadora(Long id, MontadoraRequest request){
        Montadora montadora = this.montadoraRepository.findById(id).orElseThrow(
                () -> new HandlerException("Montadora não encontrada"));

        montadora.setNome(request.getNome());
        montadora.setPais(request.getPais());

        return this.montadoraRepository.save(montadora);
    }

    public Montadora buscarMontadora(Long id){
        Montadora montadora = this.montadoraRepository.findById(id).orElseThrow(
                () -> new HandlerException("Montadora não encontrada"));
        return montadora;
    }

    public Page<Montadora> listarMontadoras(Pageable pageable){
        return this.montadoraRepository.findAll(pageable);
    }

    public  void excluirMontadora(Long id){
        Montadora montadora = this.montadoraRepository.findById(id).orElseThrow(
                () -> new HandlerException("Montadora não encontrada"));
        this.montadoraRepository.delete(montadora);
    }
}
