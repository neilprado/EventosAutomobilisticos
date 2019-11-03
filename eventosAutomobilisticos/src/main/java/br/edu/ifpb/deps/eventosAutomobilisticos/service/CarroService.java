package br.edu.ifpb.deps.eventosAutomobilisticos.service;

import br.edu.ifpb.deps.eventosAutomobilisticos.dto.request.CarroRequest;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Carro;
import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import br.edu.ifpb.deps.eventosAutomobilisticos.repository.CarroRepository;
import br.edu.ifpb.deps.eventosAutomobilisticos.repository.MontadoraRepository;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    private final CarroRepository carroRepository;
    private final MontadoraRepository montadoraRepository;

    public CarroService(CarroRepository carroRepository, MontadoraRepository montadoraRepository) {
        this.carroRepository = carroRepository;
        this.montadoraRepository = montadoraRepository;
    }

    public Carro criarCarro(CarroRequest request){
        Carro carro = new Carro();

        Montadora montadora = montadoraRepository.findById(request.getMontadoraId()).orElseThrow(
                () -> new HandlerException("Montadora não encontrada"));

        carro.setAno(request.getAno());
        carro.setMontadora(montadora);
        carro.setNome(request.getNome());
        carro.setValor(request.getValor());

        return this.carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, CarroRequest request){
        Carro carro = this.carroRepository.findById(id).orElseThrow(
                () -> new HandlerException("Carro não encontrado"));

        Montadora montadora = montadoraRepository.findById(request.getMontadoraId()).orElseThrow(
                () -> new HandlerException("Montadora não encontrada"));

        carro.setAno(request.getAno());
        carro.setMontadora(montadora);
        carro.setNome(request.getNome());
        carro.setValor(request.getValor());

        return this.carroRepository.save(carro);
    }

    public Page<Carro> listarCarros(Pageable pageable){
        return this.carroRepository.findAll(pageable);
    }

    public Carro buscarCarro(Long id){
        Carro carro = this.carroRepository.findById(id).orElseThrow(
                () -> new HandlerException("Carro não encontrado"));
        return carro;
    }

    public void removerCarro(Long id){
        Carro carro = this.carroRepository.findById(id).orElseThrow(
                () -> new HandlerException("Carro não encontrado"));
        this.carroRepository.delete(carro);
    }


}
