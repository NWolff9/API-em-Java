package Crud.API.Usuario;

public record DadosListagemUsuario(long id,String nome, String clube) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getClube());
    }
}
