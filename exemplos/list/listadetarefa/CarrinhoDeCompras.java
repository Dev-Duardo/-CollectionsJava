package exemplos.list.listadetarefa;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    // Atributo privado: 
    //'itemList': Uma lista de objetos 'Item'.
    private List<Item> itemList;

    // Construtor:
    // Inicializa 'itemList' como uma nova lista vazia.
    public CarrinhoDeCompras () {
        this.itemList = new ArrayList<>();
    }

    // Método 'adicionarItem':
    // Adiciona um novo item ao carrinho.
    public void adicionarItem (String nomeItem, double precoItem, int quantidadeItem) {
        Item item = new Item (nomeItem, precoItem, quantidadeItem);
        this.itemList.add(item);
    }

    // Método 'removerItem':
    // Remove todos os itens com um nome específico do carrinho.
    public void removerItem (String nomeItem, int quantidade) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNomeItem().equalsIgnoreCase(nomeItem)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    // Método 'calcularValorTotal':
    // Calcula o valor total de todos os itens no carrinho.
    public double calcularValorTotal() {

        double valorTotal = 0d;

        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPrecoItem() * item.getQuantidadeItem();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    // Método 'exibirItens':
    // Exibe todos os itens no carrinho.
    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.err.println("A lista está vazia!");
        }
    }

    // Método 'toString':
    // Fornece uma representação em string do objeto CarrinhoDeCompras.
    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
        "itens=" + itemList +
        '}';
    }

    // Método main:
    // Método principal que demonstra a criação e manipulação de um carrinho de compras.
    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
    
        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);
    
        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();
    
        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");
    
        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();
    
        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
