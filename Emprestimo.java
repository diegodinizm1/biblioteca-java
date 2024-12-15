import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    Livro livro;
    Usuario usuario;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    boolean emprestado;

    public Emprestimo(){}

    public Emprestimo(Livro livro, Usuario usuario){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.emprestado = true;
        this.dataDevolucao = null;
    }

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao, boolean emprestado){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
        this.emprestado = emprestado;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void registrarEmprestimo(Livro livro, Usuario usuario){
        if(livro.isEmprestado()){
            System.out.println("O livro já está emprestado");
        }else{
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucao = dataEmprestimo.plusMonths(1);
            this.emprestado = true;
            livro.setEmprestado(true);
            System.out.println("Empréstimo realizado com sucesso");
        }
    }

    public void registrarDevolucao(Livro livro, Usuario usuario){
        if (livro.isEmprestado()) {
            this.livro = livro;
            this.usuario = usuario;
            this.dataDevolucao = LocalDate.now();
            this.emprestado = false;
            livro.setEmprestado(false);
            System.out.println("Devolução registrada com sucesso.");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataEmprestimoFormatada = dataEmprestimo.format(formatter);
        String dataDevolucaoFormatada = (dataDevolucao != null) ? dataDevolucao.format(formatter) : "Não devolvido";

        return "Livro: " + livro.getTitulo() + "\nUsuário: " + usuario.getNome() +
                "\nData de Empréstimo: " + dataEmprestimoFormatada + "\nData de Devolução: " + dataDevolucaoFormatada+ "\n";
    }
}
