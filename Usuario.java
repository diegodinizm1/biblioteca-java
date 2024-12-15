import java.util.ArrayList;

public class Usuario {
    String nome;
    String cpf;

    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(){}

    public Usuario(String nome, String cpf){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
        this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf.charAt(3) == '.' && cpf.charAt(7)== '.' && cpf.charAt(11) == '-' && cpf.length() == 14) {
            this.cpf = cpf;
        }else{
            System.out.println("Cpf inválido");
        }
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void listarEmprestimos() {
        if(emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
        } else {
            for(Emprestimo emp : emprestimos) {
                System.out.println(emp);
            }
        }
    }

    public String toString(){
        return "\nNome : " + getNome() + "\nCPF : " + getCpf();
    }
}