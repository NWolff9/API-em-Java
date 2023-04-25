package Crud.API.Controller;

import Crud.API.Usuario.DadosCadastroUsuario;
import Crud.API.Usuario.DadosListagemUsuario;
import Crud.API.Usuario.Usuario;
import Crud.API.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/crud")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public List<DadosListagemUsuario>Listar(){
        return repository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosCadastroUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        repository.deleteById(id);
    }

}
