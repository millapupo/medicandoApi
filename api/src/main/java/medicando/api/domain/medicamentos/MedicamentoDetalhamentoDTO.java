package medicando.api.domain.medicamentos;

import lombok.Data;
import medicando.api.domain.usuarios.Usuario;

import java.util.Date;

public record MedicamentoDetalhamentoDTO(Long id, String nome, String dosagem, String periodicidade, Date dataInicio, String tempoDeUso, Date dataTermino) {

    public MedicamentoDetalhamentoDTO(Medicamento medicamento){
        this(medicamento.getId(), medicamento.getNome(), medicamento.getDosagem(), medicamento.getPeriodicidade(),
                medicamento.getDataInicio(), medicamento.getTempoDeUso(), medicamento.getDataTermino());
    }
}

