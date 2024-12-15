import java.util.ArrayList;

public class Biblioteca{
    private String nome;
    private int id;

    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(){}

    public Biblioteca(String nome){
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null) {
            this.nome = nome;
        }
    }


    public void adicionarUsuario(Usuario usuario){
        for(Usuario u : usuarios){
            if(u.getCpf().equals(usuario.getCpf())){
                System.out.println("Usuário já existente.");
                return;
            }
        }
        if(verificarUsuario(usuario)){
            usuarios.add(usuario);
            System.out.println("Usuário adicionado com sucesso!");
        }else{
            System.out.println("Falha ao adicionar usuário. Dados inválidos");
        }
    }

    public void removerUsuario(Usuario usuario){
        for (Usuario u : usuarios){
            if(u.getCpf().equals(usuario.getCpf())){
                usuarios.remove(usuario);
                System.out.println("Usuário removido com sucesso.");
            }else{
                System.out.println("Usuário inexistente.");
            }
        }
    }

    public void listarUsuarios(Usuario usuario){
        for(Usuario u : usuarios){
            System.out.println(u);
        }
    }

    public  void pesquisarUsuario(String cpf){
        boolean achou = false;
        for(Usuario u : usuarios){
            if(u.getCpf().equals(cpf)){
                achou = true;
                System.out.println("\nUsuário encontrado com o CPF informado\n");
                System.out.println(u);
            }
        }
        if(!achou){
            System.out.println("Usuário inexistente!");
        }
    }

    public boolean verificarUsuario(Usuario usuario){
        return usuario.getNome() != null && !usuario.getNome().isEmpty() &&
                usuario.getCpf() != null && !usuario.getCpf().isEmpty();
    }

    public void adicionarLivro(String titulo, String autor, float preco){
        for(Livro livro : livros){
            if(livro.getId() == id){
                System.out.println("Livro já adicionado!");
                return;
            }
        }
        if(verificarLivro(titulo, autor, preco)) {
            int id = livros.size()+1;
            livros.add(new Livro(titulo, autor, id, preco, false));
            System.out.println("Livro adicionado com sucesso!");
        }
    }

    public void removerLivro(int id){
        boolean achou = false;
        for(Livro livro : livros){
            if(livro.getId() == id){
                achou = true;
                livros.remove(livro);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        if(!achou){
            System.out.println("Livro inexistente!");
        }
    }

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("\nLista vazia\n");
        }else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public Livro pesquisarLivro(int id){
        boolean achou = false;
        for(Livro livro : livros){
            if(livro.getId() == id){
                achou = true;
                return livro;
            }
        }
        if(!achou){
            System.out.println("Livro inexistente!");
            return null;
        }
        return null;
    }

    public boolean verificarLivro(String titulo, String autor, float preco){
        if(titulo != null && autor != null && preco > 0){
            return true;
        }else {
            return false;
        }
    }
}
