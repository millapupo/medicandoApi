package medicando.api.domain.medicamentos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public record MedicamentoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String dosagem,
        @NotBlank
        String periodicidade,
        Data dataInicio,
        String tempoDeUso,
        Data dataTermino

) {

}