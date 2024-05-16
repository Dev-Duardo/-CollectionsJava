# Collections em Java

Em Java, "Collections" (ou coleções) referem-se a estruturas de dados que permitem armazenar e manipular grupos de objetos. Essas estruturas são fundamentais para o desenvolvimento de programas Java, pois fornecem uma maneira eficiente de organizar e trabalhar com conjuntos de elementos.

## Conhecendo a Hierarquia do Collection Framework API Java

O Collection Framework API em Java fornece uma estrutura para armazenar e manipular coleções de objetos. Ele é organizado em uma hierarquia de interfaces e classes. As principais interfaces na hierarquia são `Collection`, `List`, `Set` e `Map`. Cada uma dessas interfaces tem várias implementações concretas.

- `Collection`: Representa uma coleção de objetos e é a raiz da hierarquia. As interfaces `List`, `Set`, e Queue estendem `Collection`.
- `List`: É uma coleção ordenada que permite elementos duplicados. Exemplos de implementações são `ArrayList` e `LinkedList`.
- `Set`: É uma coleção que não permite elementos duplicados e não garante a ordem dos elementos. Exemplos de implementações são `HashSet` e `TreeSet`.
- Map: É uma coleção de pares chave-valor, onde cada chave é única. Exemplos de implementações são `HashMap` e `TreeMap`. Embora não seja filha direta da interface `collection` ela é considerada uma coleção devido a sua função.

![Hierarquia de do framework Collection em Java](image.png)
Fonte imagem: https://data-flair.training/blogs/collection-framework-in-java/

Todas as interfaces e classes estão dentro do `package` `java.util`.

> Link dos métodos: [Documentação oficial Oracle - Interface Collection](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)

## Entendendo o Generics Type

O Generics Type é uma característica introduzida no Java 5 para permitir que classes, interfaces e métodos operem com tipos de dados genéricos. Isso permite escrever código que seja mais flexível, reutilizável e seguro em relação aos tipos de dados.

- O símbolo `<>` é chamado de "diamond" ou "diamond operator", recurso introduzido no Java 7, usado no contexto dos tipos genéricos em Java para inferir automaticamente o tipo com base no contexto

Por exemplo, consideremos a classe `ArrayList`:

```Java
ArrayList<String> list = new ArrayList<String>();
list.add("Hello");
String str = list.get(0);
```

> Nesse exemplo, ArrayList<String> especifica que a lista irá conter apenas strings. O uso de Generics Type garante que, se tentarmos adicionar um tipo diferente de objeto à lista, receberemos um erro em tempo de compilação.

- A classe `Box` a seguir será modificada para demonstrar o conceito:

```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

- Para atualizar a classe `Box` para usar generics, você cria uma declaração de tipo genérico alterando o código `public class Box` para `public class Box<T>`.
- Isso introduz a variável de tipo, `T`, que pode ser usada em qualquer lugar dentro da classe:

```java
/**
Versão genérica da classe Box.
@param <T> o tipo do valor sendo armazenado
*/
public class Box<T> {
	// T representa "Type" (tipo)
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

- Como você pode ver, todas as ocorrências de Object são substituídas por T.
- Uma variável de tipo pode ser qualquer tipo não primitivo que você especificar: qualquer tipo de classe, qualquer tipo de interface, qualquer tipo de array ou até mesmo outra variável de tipo.
- Essa mesma técnica pode ser aplicada para criar interfaces genérica.
- Os nomes de parâmetros de tipo mais comumente usados são:
  - E - Elemento (usado extensivamente pelo Java Collections Framework)
    - K - Chave
    - N - Número
    - T - Tipo
    - V - Valor
    - S, U, V, etc. - 2º, 3º, 4º tipos

### Vantagens simples de usar generics nas interfaces Collection em Java

1. **Segurança do tipo de dados**: O uso de generics garante que apenas objetos de um tipo específico possam ser adicionados à coleção, evitando erros de tipo e garantindo que você esteja lidando com os dados corretos.
2. **Código mais legível**: Ao usar generics, você pode especificar o tipo de dados esperado ou retornado pela coleção, o que torna o código mais fácil de entender e ler.
3. **Detecta erros mais cedo**: O compilador verifica se você está usando os tipos corretos durante a compilação, ajudando a identificar erros de tipo antes mesmo de executar o programa.
4. **Reutilização de código**: Com generics, você pode criar classes e métodos genéricos que funcionam com diferentes tipos de coleções, evitando a necessidade de duplicar código para cada tipo específico.
5. **Melhor desempenho**: O uso de generics pode melhorar o desempenho, pois evita a necessidade de conversões de tipo desnecessárias e permite que o compilador otimize o código com base no tipo especificado.

---

### Referências

[1] "Java Tutorials - Generics - Generic Types." Oracle. Disponível em: https://docs.oracle.com/javase/tutorial/java/generics/types.html.

## Conhecendo as interfaces, Comparable e Comparator

Ambas as interfaces são usadas para definir a ordenação de objetos em coleções em Java.

### Comparable

- `Comparable` fornece uma única sequência de ordenação. Em outras palavras, podemos ordenar a coleção com base em um único elemento, como id, nome e preço.
- `Comparable` afeta a classe original, ou seja, a classe atual é modificada.
- `Comparable` fornece o método `compareTo()` para ordenar elementos.
- `Comparable` está presente no pacote `java.lang`.
- Podemos ordenar os elementos da lista do tipo `Comparable` usando o método `Collections.sort(List)`.

### Comparator

- O `Comparator` fornece o método `compare()` para ordenar elementos.
- O `Comparator` fornece múltiplas sequências de ordenação. Em outras palavras, podemos ordenar a coleção com base em múltiplos elementos, como id, nome, preço, etc.
- O `Comparator` não afeta a classe original, ou seja, a classe atual não é modificada.
- Um `Comparator` está presente no pacote `java.util`.
- Podemos ordenar os elementos da lista do tipo `Comparator` usando o método `Collections.sort(List, Comparator)`.

### Collections

- A classe `Collections` é uma classe utilitária do Java para operações comuns em coleções.
- Ela fornece métodos para ordenação, busca, manipulação e sincronização de coleções.
- O método `sort()` é usado para ordenar uma lista em ordem ascendente.
- O método `sort()` em conjunto com `Collections.reverseOrder()` permite ordenar em ordem descendente.

```Java
package exemplos.comparablecomparator;
import java.util.Comparator;

public class ComparableComparator {

    // Classe que representa um livro e implementa a interface Comparable<Livro>
    class Livro implements Comparable<Livro> {
        private String titulo;
        private String autor;
        private int ano;

        // Construtor
        public Livro(String ti, String au, int an) {
            this.titulo = ti;
            this.autor = au;
            this.ano = an;
        }

        // Método compareTo usado para ordenar livros por título
        public int compareTo(Livro l) {
            // Comparação de títulos de livros
            return titulo.compareTo(l.titulo);
        }

        // Métodos getters para acessar os dados privados
        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public int getAno() {
            return ano;
        }
    }

    // Classe para comparar Livro por autor
    class CompararAutor implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
            // Comparação de livros por autor
            return l1.getAutor().compareTo(l2.getAutor());
        }
    }

    // Classe para comparar Livro por ano
    class CompararAno implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
            // Comparação de livros por ano
            if (l1.getAno() < l2.getAno())
                return -1;
            if (l1.getAno() > l2.getAno())
                return 1;
            else
                return 0;
        }
    }

    // Classe para comparar Livro por ano, autor e título
    class CompararAnoAutorTitulo implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
            // Comparação de livros por ano
            int ano = Integer.compare(l1.getAno(), l2.getAno());
            if (ano != 0)
                return ano;
            // Se os anos são iguais, compara por autor
            int autor = l1.getAutor().compareTo(l2.getAutor());
            if (autor != 0)
                return autor;
            // Se os autores são iguais, compara por título
            return l1.getTitulo().compareTo(l2.getTitulo());
        }
    }
}

```

### Referências

[1] "Comparable vs Comparator in Java." GeeksforGeeks. Disponível em: https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/.

[2] "Difference between Comparable and Comparator in Java." JavaTpoint. Disponível em: https://www.javatpoint.com/difference-between-comparable-and-comparator.

[3] "Java™ Platform, Standard Edition 17 API Specification - Class Collections." Oracle. Disponível em: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html.

## List Interface

- A interface <code>List</code> é uma coleção ordenada que permite a inclusão de elementos duplicados.
- É um dos tipos de coleção mais utilizados em Java, e as classes de implementação comuns são <code>ArrayList</code> e <code>LinkedList</code>.
- A <code>List</code> se assemelha a uma matriz com comprimento dinâmico, permitindo adicionar ou remover elementos.
- A interface <code>List</code> fornece métodos úteis para adicionar elementos em posições específicas, remover ou substituir elementos com base no índice e obter sublistas usando índices.
- A classe <code>Collections</code> fornece algoritmos úteis para manipulação de <code>List</code>, como ordenação (sort), embaralhamento (shuffle), reversão (reverse) e busca binária (binarySearch).

> **ArrayList**: O ArrayList é uma implementação da interface List que armazena os elementos em uma estrutura de array redimensionável. Isso significa que ele pode crescer automaticamente à medida que novos elementos são adicionados. A principal vantagem do ArrayList é o acesso rápido aos elementos por meio de índices, o que permite recuperar um elemento específico de forma eficiente. No entanto, adicionar ou remover elementos no meio da lista pode ser mais lento, pois requer a realocação de elementos.

> **LinkedList**: O LinkedList é uma implementação da interface List que armazena os elementos em uma lista duplamente vinculada. Cada elemento contém referências para o elemento anterior e próximo na lista. A principal vantagem do LinkedList é a eficiência na adição ou remoção de elementos no início ou no final da lista, pois não é necessário realocar elementos. No entanto, o acesso aos elementos por meio de índices é mais lento, pois requer percorrer a lista até o elemento desejado.

> **Vector**: O Vector é uma implementação antiga da interface List que é semelhante ao ArrayList, mas é sincronizada, ou seja, é thread-safe. Isso significa que várias threads podem manipular um objeto Vector ao mesmo tempo sem causar problemas de concorrência. No entanto, essa sincronização adiciona uma sobrecarga de desempenho, tornando o Vector menos eficiente do que o ArrayList em cenários em que a concorrência não é um problema. Por esse motivo, o uso do Vector é menos comum em aplicações modernas.

### Referências:

[1] "Collections in Java Tutorial." DigitalOcean Community. Disponível em: https://www.digitalocean.com/community/tutorials/collections-in-java-tutorial.

[2] "Java™ Platform, Standard Edition 17 API Specification - Class List." Oracle. Disponível em: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html.

# Fixando os Conhecimentos

Exercícios:

1. Operações Básicas com List
2. Pesquisa em List
3. Ordenação nas List

## Operações Básicas com List

### 1. Lista de Tarefas

<p>Crie uma classe chamada "ListaTarefas" que possui uma lista de tarefas como atributo. Cada tarefa é representada por uma classe chamada "Tarefa" que possui um atributo de descrição. Implemente os seguintes métodos:

- `adicionarTarefa(String descricao)`: Adiciona uma nova tarefa à lista com a descrição fornecida.
- `removerTarefa(String descricao)`: Remove uma tarefa da lista com base em sua descrição.
- `obterNumeroTotalTarefas()`: Retorna o número total de tarefas na lista.
- `obterDescricoesTarefas()`: Retorna uma lista contendo a descrição de todas as tarefas na lista.
</p>

### 2. Carrinho de Compras:

<p>Crie uma classe chamada "CarrinhoDeCompras" que representa um carrinho de compras online. O carrinho deve ser implementado como uma lista de itens. Cada item é representado por uma classe chamada "Item" que possui atributos como nome, preço e quantidade. Implemente os seguintes métodos:

- `adicionarItem(String nome, double preco, int quantidade)`: Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
- `removerItem(String nome)`: Remove um item do carrinho com base no seu nome.
- `calcularValorTotal()`: Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item.
- `exibirItens()`: Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.
</p>

---

## Pesquisa em List

### 1. Catálogo de Livros

<p>Crie uma classe chamada "CatalogoLivros" que possui uma lista de objetos do tipo "Livro" como atributo. Cada livro possui atributos como título, autor e ano de publicação. Implemente os seguintes métodos:

- `adicionarLivro(String titulo, String autor, int anoPublicacao)`: Adiciona um livro ao catálogo.
- `pesquisarPorAutor(String autor)`: Pesquisa livros por autor e retorna uma lista com os livros encontrados.
- `pesquisarPorIntervaloAnos(int anoInicial, int anoFinal)`: Pesquisa livros publicados em um determinado intervalo de anos e retorna uma lista com os livros encontrados.
- `pesquisarPorTitulo(String titulo)`: Pesquisa livros por título e retorna o primeiro livro encontrado.
</p>

### 2. Soma de Números

<p>Crie uma classe chamada "SomaNumeros" que possui uma lista de números inteiros como atributo. Implemente os seguintes métodos:

- `adicionarNumero(int numero)`: Adiciona um número à lista de números.
- `calcularSoma()`: Calcula a soma de todos os números na lista e retorna o resultado.
- `encontrarMaiorNumero()`: Encontra o maior número na lista e retorna o valor.
- `encontrarMenorNumero()`: Encontra o menor número na lista e retorna o valor.
- `exibirNumeros()`: Retorna uma lista contendo todos os números presentes na lista.

---

## Ordenação em List

### 1. Ordenação de Pessoas

<p>Crie uma classe chamada "OrdenacaoPessoas" que possui uma lista de objetos do tipo "Pessoa" como atributo. Cada pessoa possui atributos como nome, idade e altura. Implemente os seguintes métodos:

- `adicionarPessoa(String nome, int idade, double altura)`: Adiciona uma pessoa à lista.
- `ordenarPorIdade()`: Ordena as pessoas da lista por idade usando a interface Comparable.
- `ordenarPorAltura()`: Ordena as pessoas da lista por altura usando um Comparator personalizado.
</p>

### 2. Ordenação de Números

<p>Crie uma classe chamada "OrdenacaoNumeros" que possui uma lista de números inteiros como atributo. Implemente os seguintes métodos:

- `adicionarNumero(int numero)`: Adiciona um número à lista.
- `ordenarAscendente()`: Ordena os números da lista em ordem ascendente usando a interface Comparable e a class Collections.
- `ordenarDescendente()`: Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
</p>

---
