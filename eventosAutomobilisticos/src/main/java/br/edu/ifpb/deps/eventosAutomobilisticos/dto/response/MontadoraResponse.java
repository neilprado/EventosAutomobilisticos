package br.edu.ifpb.deps.eventosAutomobilisticos.dto.response;

import br.edu.ifpb.deps.eventosAutomobilisticos.model.Montadora;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class MontadoraResponse {
    private Long id;
    private String nome;
    private String pais;
    private Long carroId;

    public static MontadoraResponse from(Montadora montadora){
        MontadoraResponse response = new MontadoraResponse();

        response.setCarroId(montadora.getCarros().get().getId());
        response.setId(montadora.getId());
        response.setNome(montadora.getNome());
        response.setPais(montadora.getPais());

        return response;
    }

    public static Page<MontadoraResponse> from (Page<Montadora> montadoras){
        Page<MontadoraResponse> responses = montadoras.map(montadora -> {
            MontadoraResponse response = new MontadoraResponse();

            response.setCarroId(montadora.getCarros().get().getId());
            response.setId(montadora.getId());
            response.setNome(montadora.getNome());
            response.setPais(montadora.getPais());

            return response;
        });
        return responses;
    }
}
