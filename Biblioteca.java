import java.util.ArrayList;

public class Biblioteca{
    private String nome;

    ArrayList<Livro> livros = new ArrayList<>();

    public Biblioteca() {}

    public Biblioteca(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome!=null) {
            this.nome = nome;
        }
    }

    public void adicionarLivro(String titulo, String autor, int numPaginas, float preco){
        if (verificarLivro(titulo, autor, numPaginas, preco)) {
            for (Livro livro : livros) {
                if(livro.getTitulo().toLowerCase().equals(titulo)){
                    System.out.println("\nLivro já existente\n");
                    return;
                }
            }
            Livro livro = new Livro(titulo, autor, numPaginas, preco);
            livros.add(livro);
            System.out.println("\nLivro adicionado com sucesso.\n");
        }else{
            System.out.println("\nOcorreu um erro ao tentar adicionar o livro.\n");
        }
    }

    public  void removerLivro(String titulo){
        boolean removido = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().toLowerCase().equals(titulo)) {
                livros.remove(i);
                removido = true;
                System.out.println("\nLivro removido com sucesso.\n");
                break;
            }
        }
        if (!removido) {
            System.out.println("\nLivro inexistente.\n");
        }
    }

    public  void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("\nBiblioteca vazia.\n");
        }else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public  void pesquisarLivro(String titulo){
        boolean existe = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().equals(titulo)) {
                existe = true;
                System.out.println(livro);
                break;
            }
        }
        if (!existe){
            System.out.println("\nLivro inexistente.\n");
        }
    }

    public boolean verificarLivro(String titulo, String autor, int numPaginas, float preco) {
        if (titulo == null || titulo.isBlank() || autor == null || autor.isBlank() || numPaginas <= 0 || preco <= 0) {
            System.out.println("\nParâmetros do livro inválidos.\n");
            return false;
        }
        return true;
    }
}
