public class Livro{
    private String titulo;
    private String autor;
    private int numPaginas;
    private float preco;

    public Livro() {}

    public Livro(String titulo, String autor, int numPaginas, float preco) {
        setTitulo(titulo);
        setAutor(autor);
        setNumPaginas(numPaginas);
        setPreco(preco);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo!=null) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor!=null) {
            this.autor = autor;
        }
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas>0) {
            this.numPaginas = numPaginas;
        }
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco>0) {
            this.preco = preco;
        }
    }

    public String toString() {
        return "\nLivro:" +
                "\nTitulo: '" + getTitulo() + '\'' +
                "\nAutor: '" + getAutor() + '\'' +
                "\nNumero de Paginas:" + getNumPaginas() +
                "\nPreço: " + getPreco() +
                '\n';
    }
}
