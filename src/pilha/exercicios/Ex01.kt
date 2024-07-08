class PilhaEstatica(private val tamanho: Int) {
    private val elementos: Array<Int?> = arrayOfNulls<Int?>(tamanho)
    private var topo: Int = -1

    // Método para empilhar um elemento
    fun push(elemento: Int) {
        if (isFull()) {
            throw StackOverflowError("A pilha está cheia")
        }
        elementos[++topo] = elemento
    }

    // Método para desempilhar um elemento
    fun pop(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        val elemento = elementos[topo]
        elementos[topo--] = null
        return elemento
    }

    // Método para verificar o elemento no topo da pilha
    fun peek(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        return elementos[topo]
    }

    // Método para verificar se a pilha está vazia
    fun isEmpty(): Boolean {
        return topo == -1
    }

    // Método para verificar se a pilha está cheia
    fun isFull(): Boolean {
        return topo == tamanho - 1
    }

    // Método para verificar o tamanho atual da pilha
    fun size(): Int {
        return topo + 1
    }

    // Método para esvaziar a pilha
    fun clear() {
        for (i in 0..topo) {
            elementos[i] = null
        }
        topo = -1
    }
}

fun main() {
    val pilha = PilhaEstatica(5)

    // Testando os métodos
    println("A pilha está vazia? ${pilha.isEmpty()}") // true

    pilha.push(10)
    pilha.push(20)
    pilha.push(30)
    pilha.push(40)
    pilha.push(50)

    println("A pilha está cheia? ${pilha.isFull()}") // true

    println("Elemento no topo: ${pilha.peek()}") // 50
    println("Tamanho da pilha: ${pilha.size()}") // 5

    println("Desempilhando: ${pilha.pop()}") // 50
    println("Elemento no topo: ${pilha.peek()}") // 40

    println("Esvaziando a pilha...")
    pilha.clear()
    println("A pilha está vazia? ${pilha.isEmpty()}") // true
    println("Tamanho da pilha: ${pilha.size()}") // 0
}
