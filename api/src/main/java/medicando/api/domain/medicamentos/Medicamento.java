package medicando.api.domain.medicamentos;
import jakarta.persistence.*;
import lombok.*;
import medicando.api.domain.usuarios.Usuario;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Table(name = "medicamentos")
@Entity(name = "Medicamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

public class Medicamento {

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String dosagem;
    private String periodicidade;
    private Date dataInicio;
    private String tempoDeUso;
    private Date dataTermino;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicamento_id")
    private List<Medicamento> listaDeMedicamentos;

    public Medicamento(MedicamentoDTO dados){
        this.nome = dados.nome();
        this.dosagem = dados.dosagem();
        this.periodicidade = dados.periodicidade();
        this.dataInicio = (Date) dados.dataInicio();
        this.tempoDeUso = dados.tempoDeUso();
        this.dataTermino = (Date) dados.dataTermino();
    }
}
