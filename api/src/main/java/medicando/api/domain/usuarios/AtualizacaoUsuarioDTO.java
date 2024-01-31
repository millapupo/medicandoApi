package medicando.api.domain.usuarios;

public record AtualizacaoUsuarioDTO(Long id, String nome, String email, String telefone, String planoSaude, String numeroCarteirinha) {
}
