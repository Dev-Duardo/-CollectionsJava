package exemplos.list.operacoesbasicas.carrinhodecompras;

public class Item {
    //Atributos privados:
    private String nomeItem;
    private double precoItem;
    private int quantidadeItem;

    // Construtor: Permite criar um objeto Item com um nome, preço e quantidade específicos.
    public Item (String nomeItem, double precoItem, int quantidadeItem){
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
        this.quantidadeItem = quantidadeItem;
    }

    // Métodos getters: Permitem acessar os atributos privados.
    public String getNomeItem() {
        return nomeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    // Método toString: Fornece uma representação em string do objeto Item.
    @Override
	public String toString() {
		return "Itens: " +
				"nome = '" + nomeItem + '\'' +
				", preco = R$ " + precoItem +
				", quant= " + quantidadeItem +
				'}';
	}
    


}
