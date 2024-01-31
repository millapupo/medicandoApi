package medicando.api.controller;

import jakarta.validation.Valid;
import medicando.api.domain.usuarios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid UsuarioDTO dados, UriComponentsBuilder uriComponentsBuilder){
        repository.save(new Usuario(dados));
        var usuario = new Usuario((dados));
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDetalhamentoDTO(usuario));
    }
    @GetMapping
    public ResponseEntity<Page<ListagemUsuarioDTO>>listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemUsuarioDTO::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoUsuarioDTO dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new UsuarioDetalhamentoDTO(usuario));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
        return ResponseEntity.ok(new UsuarioDetalhamentoDTO(usuario));
    }

}
