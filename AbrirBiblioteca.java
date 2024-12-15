import java.util.Scanner;

public class AbrirBiblioteca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca UFC");
        Usuario usuario = new Usuario();
        Emprestimo emprestimo = new Emprestimo();
        AbrirBiblioteca abrirBiblioteca = new AbrirBiblioteca();

        while (true) {
            abrirBiblioteca.menuPrincipal(biblioteca, usuario, emprestimo, input);
        }
    }

    public void menuPrincipal(Biblioteca biblioteca, Usuario usuario, Emprestimo emprestimo, Scanner input) {
        System.out.println("Bem vindo ao sistema de biblioteca!");
        System.out.println("1 - Menu Biblioteca");
        System.out.println("2 - Menu Emprestimos");
        System.out.println("3 - Menu Usuários");
        System.out.println("0 - Sair");

        int escolha = input.nextInt();

        if (escolha == 0) {
            System.out.println("Saindo do sistema...");
            System.exit(0);
        } else if (escolha == 1) {
            menuBiblioteca(biblioteca, input);
        } else if (escolha == 2) {
            menuEmprestimo(biblioteca, usuario, emprestimo, input);
        } else if (escolha == 3) {
            menuUsuario(biblioteca, usuario, input);
        } else {
            System.out.println("Operação Inválida");
        }
    }

    public void menuBiblioteca(Biblioteca biblioteca, Scanner input) {
        System.out.println("\nMenu Biblioteca:\n");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Excluir Livro");
        System.out.println("3 - Listar Livros");
        System.out.println("0 - Voltar");

        int escolha = input.nextInt();
        input.nextLine(); // Limpa o buffer

        if (escolha == 0) {
            return;
        } else if (escolha == 1) {
            System.out.println("Qual o nome do livro?");
            String nome = input.nextLine();
            System.out.println("Quem escreveu o livro?");
            String autor = input.nextLine();
            System.out.println("Qual o preço do livro?");
            float preco = input.nextFloat();
            biblioteca.adicionarLivro(nome, autor, preco);
        } else if (escolha == 2) {
            System.out.println("Qual o ID do livro?");
            int id = input.nextInt();
            input.nextLine(); // Limpa o buffer
            biblioteca.removerLivro(id);
        } else if (escolha == 3) {
            biblioteca.listarLivros();
        } else {
            System.out.println("Operação Inválida");
        }
    }

    public void menuEmprestimo(Biblioteca biblioteca, Usuario usuario, Emprestimo emprestimo, Scanner input) {
        System.out.println("\nMenu Emprestimos:\n");
        System.out.println("1 - Cadastrar Emprestimo");
        System.out.println("2 - Excluir Emprestimo");
        System.out.println("3 - Listar Emprestimos");
        System.out.println("0 - Voltar");

        int escolha = input.nextInt();
        input.nextLine(); // Limpa o buffer

        if (escolha == 0) {
            return;
        } else if (escolha == 1) {
            System.out.println("Informe o CPF do usuário:");
            String cpf = input.nextLine();
            usuario.setCpf(cpf);

            System.out.println("Informe o ID do livro:");
            int idLivro = input.nextInt();
            input.nextLine();

            Livro livro = biblioteca.pesquisarLivro(idLivro);
            if (livro != null && !livro.isEmprestado()) {
                emprestimo.registrarEmprestimo(livro, usuario);
                usuario.adicionarEmprestimo(emprestimo);
            } else {
                System.out.println("Livro não disponível para empréstimo.");
            }
        } else if (escolha == 2) {
            System.out.println("Informe o ID do livro para devolver:");
            int idLivro = input.nextInt();
            input.nextLine();

            Livro livro = biblioteca.pesquisarLivro(idLivro);
            if (livro != null && livro.isEmprestado()) {
                emprestimo.registrarDevolucao(livro, usuario);
            } else {
                System.out.println("Livro não emprestado ou inexistente.\n");
            }
        } else if (escolha == 3) {
            System.out.println("\nListando todos os empréstimos:\n");
            usuario.listarEmprestimos();
        } else {
            System.out.println("Operação Inválida");
        }
    }

    public void menuUsuario(Biblioteca biblioteca, Usuario usuario, Scanner input) {
        System.out.println("\nMenu Usuários:\n");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Excluir Usuário");
        System.out.println("3 - Listar Usuários");
        System.out.println("0 - Voltar");

        int escolha = input.nextInt();
        input.nextLine();

        if (escolha == 0) {
            return;
        } else if (escolha == 1) {
            System.out.println("Digite o nome do usuário:");
            String nome = input.nextLine();
            System.out.println("Digite o CPF do usuário:");
            String cpf = input.nextLine();
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            biblioteca.adicionarUsuario(usuario);
        } else if (escolha == 2) {
            System.out.println("Digite o CPF do usuário para remoção:");
            String cpf = input.nextLine();
            Usuario u = new Usuario();
            u.setCpf(cpf);
            biblioteca.removerUsuario(u);
        } else if (escolha == 3) {
            biblioteca.listarUsuarios(usuario);
        } else {
            System.out.println("Operação Inválida");
        }
    }
}
