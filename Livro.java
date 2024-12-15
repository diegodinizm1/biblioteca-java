import java.util.ArrayList;

public class Livro{
    private String titulo;
    private String autor;
    private int id;
    private float preco;
    private boolean emprestado;

    public Livro(){}

    public Livro(String titulo, String autor, int id, float preco, boolean emprestado) {
        setTitulo(titulo);
        setAutor(autor);
        setId(id);
        setPreco(preco);
        setEmprestado(emprestado);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(!titulo.isEmpty()) {
            this.titulo = titulo;
        }else{
            System.out.println("Titulo não pode ser vazio");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(!autor.isEmpty()) {
            this.autor = autor;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        }
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if(preco > 0) {
            this.preco = preco;
        }
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public boolean emprestarLivro(Usuario usuario){
        if(this.emprestado){
            System.out.println("O livro '"+ this.titulo + "'foi emprestado para o usuário '"+ usuario.getNome() +"'");
            return true;
        }

        this.emprestado = true;
        System.out.println("O livro foi emprestado com sucesso");
        return true;
    }

    public boolean devolverLivro(Usuario usuario){
        if (!this.emprestado) {
            System.out.println("O livro '" + this.titulo + "' não está emprestado.");
            return false;
        }

        this.emprestado = false;
        System.out.println("O livro '" + this.titulo + "' foi devolvido com sucesso por '" + usuario.getNome() + "'.");
        return true;
    }



    public String toString(){
        return "\nLivro : " + getTitulo() +
                "\nID : " + getId() +
                "\nAutor : " + getAutor() +
                "\nPreço : " + getPreco() +
                "\nEmprestado : " + (isEmprestado() ? "Sim" : "Não") +
                "\n";
    }
}
