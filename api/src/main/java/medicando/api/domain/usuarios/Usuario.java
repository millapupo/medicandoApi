package medicando.api.domain.usuarios;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String planoSaude;
    private String numeroCarteirinha;
    private boolean ativo;


    public Usuario(UsuarioDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.planoSaude = dados.planoSaude();
        this.numeroCarteirinha = dados.numeroCarteirinha();
    }

    public void atualizarInformacoes(AtualizacaoUsuarioDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.planoSaude() != null){
            this.planoSaude = dados.planoSaude();
        }
        if(dados.numeroCarteirinha()!= null){
            this.numeroCarteirinha = dados.numeroCarteirinha();
        }
    }
    public void excluir(){this.ativo = false;}
}
