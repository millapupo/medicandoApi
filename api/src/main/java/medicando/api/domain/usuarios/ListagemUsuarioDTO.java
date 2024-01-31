package medicando.api.domain.usuarios;

public record ListagemUsuarioDTO(Long id, String nome, String email, String telefone, String planoSaude, String numeroCarteirinha) {

    public ListagemUsuarioDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getTelefone(),
                usuario.getPlanoSaude(), usuario.getNumeroCarteirinha());
    }
}
