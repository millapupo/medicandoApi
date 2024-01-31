package medicando.api.domain.contatos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContatoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank @Email
        String email
) {}
