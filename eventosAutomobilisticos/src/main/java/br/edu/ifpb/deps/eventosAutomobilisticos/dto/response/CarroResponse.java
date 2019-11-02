package br.edu.ifpb.deps.eventosAutomobilisticos.dto.response;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Carro;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data
public class CarroResponse {
    private Long id;
    private String nome;
    private int ano;
    private BigDecimal valor;
    private Long montadoraId;

    public static CarroResponse from(Carro carro){
        CarroResponse response = new CarroResponse();

        response.setId(carro.getId());
        response.setNome(carro.getNome());
        response.setAno(carro.getAno());
        response.setMontadoraId(carro.getMontadora().getId());
        response.setValor(carro.getValor());

        return response;
    }

    public static Page<CarroResponse> from(Page<Carro> carros){
        Page<CarroResponse> responses = carros.map(carro -> {
            CarroResponse carroResponse = new CarroResponse();
            carroResponse.setId(carro.getId());
            carroResponse.setValor(carro.getValor());
            carroResponse.setMontadoraId(carro.getMontadora().getId());
            carroResponse.setAno(carro.getAno());
            carroResponse.setNome(carro.getNome());
            return carroResponse;
        });
        return responses;
    }
}
