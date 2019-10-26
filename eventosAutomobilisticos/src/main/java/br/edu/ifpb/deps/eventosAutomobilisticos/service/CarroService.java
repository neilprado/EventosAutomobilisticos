package br.edu.ifpb.deps.eventosAutomobilisticos.service;

import br.edu.ifpb.deps.eventosAutomobilisticos.repository.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }


}
