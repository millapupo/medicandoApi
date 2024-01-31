package medicando.api.domain.usuarios;

public record UsuarioDetalhamentoDTO(Long id,String nome, String email, String telefone, String planoSaude, String numeroCarteirinha) {
    
    public UsuarioDetalhamentoDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getTelefone(),
                usuario.getPlanoSaude(), usuario.getNumeroCarteirinha());
    }

}

