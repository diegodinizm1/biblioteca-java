import java.util.Scanner;

public class AbrirBiblioteca{
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca UFC");

        AbrirBiblioteca programa = new AbrirBiblioteca();
        while (true) {
            programa.menuBiblioteca(biblioteca, input);
        }
    }
    public void menuBiblioteca(Biblioteca biblioteca, Scanner input){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Remover Livro");
        System.out.println("3 - Listar Livros");
        System.out.println("4 - Pesquisar Livro");
        System.out.println("0 - Sair");
        int escolha = input.nextInt();
        input.nextLine();
        if (escolha == 0) {
            System.out.println("Obrigado por usar nosso programa.\n");
            System.exit(0);
        }
        if (escolha == 1) {
            System.out.println("Qual o nome do livro que deseja adicionar?");
            String titulo = input.nextLine();
            System.out.println("Qual o nome do autor do livro?");
            String autor = input.nextLine();
            System.out.println("Qual o número de paginas do livro?");
            int numPaginas = input.nextInt();
            System.out.println("Qual o preço do livro?");
            float preco = input.nextFloat();
            biblioteca.adicionarLivro(titulo, autor, numPaginas, preco);
        } else if (escolha == 2) {
            System.out.println("Qual o nome do livro que deseja remover?");
            String titulo = input.nextLine();
            biblioteca.removerLivro(titulo);
        } else if (escolha == 3) {
            biblioteca.listarLivros();
        } else if (escolha == 4) {
            System.out.println("Qual o nome do livro que deseja pesquisar?");
            String titulo = input.nextLine();
            biblioteca.pesquisarLivro(titulo);
        } else {
            System.out.println("Operador inválido\n");
        }
    }
}
