package medicando.api.domain.usuarios;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank @Email
        String email,
        String planoSaude,
        String numeroCarteirinha

) {}