interface Stackable {

    //Métodos principais
    // Insere um elemento no topo da pilha
    fun push(elemento: Any)
    // Remove e retorna o elemento do topo da pilha
    fun pop(): Any
    // Retorna o elemento do topo da pilha sem removê-lo
    fun peek(): Any


    // Métodos auxiliares
    // Verifica se a pilha está vazia
    fun isEmpty(): Boolean
    // Verifica se a pilha está cheia (para pilhas com tamanho fixo utilizando array)
    fun isFull(): Boolean
    //Retorna o tamanho da pilha
    fun size(): Int
     // Retorna uma representação em string dos elementos na pilha
    fun print(): String
}