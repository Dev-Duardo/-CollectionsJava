package exemplos.list.pesquisa;

public class Livro {
    //Atributos
    private String titulo;
    private String autor;
    private int anoPublicacao;

    //Construtor
    public Livro (String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

}
