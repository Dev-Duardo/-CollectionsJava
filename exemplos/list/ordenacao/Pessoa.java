package exemplos.list.ordenacao;
import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa> {
    //atributos
    private String nome;
    private int idade;
    private double altura;
    
    //contrutor: permitir criar um objeto pessoa
    public Pessoa (String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public int compareTo(Pessoa p) {
        // TODO Auto-generated method stub
        return Integer.compare(idade, p.getIdade());
    }

    public static class ComparatorPorAltura implements Comparator<Pessoa> {
        @Override
        public int compare(Pessoa p1, Pessoa p2) {
            return Double.compare(p1.getAltura(), p2.getAltura());
        }
    }


    //get
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }


    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", altura=" + altura + "]";
    }

    
    

}
