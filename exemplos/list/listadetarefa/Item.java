package exemplos.list.listadetarefa;
import java.util.List;
import java.util.ArrayList;

public class Item {

    private 
    @Override
    public String toString() {
        return "Item []";
    }

    public String getItem() {
        return Item;
    }
}

public class CarrinhoDeCompras {
    //atributos
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = ArrayList<>();
    }

    public void adicionarItem(String nomeItem, double precoItem, int quantidadeItem) {
        Item item = new Item(nomeItem, precoItem, quantidadeItem);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nomeItem)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

}
