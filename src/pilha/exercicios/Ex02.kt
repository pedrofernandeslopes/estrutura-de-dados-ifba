class No(val valor: Int, var proximo: No?)

class PilhaDinamica {
    private var topo: No? = null
    private var tamanho: Int = 0

    // Método para empilhar um elemento
    fun push(elemento: Int) {
        val novoNo = No(elemento, topo)
        topo = novoNo
        tamanho++
    }

    // Método para desempilhar um elemento
    fun pop(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        val valor = topo?.valor
        topo = topo?.proximo
        tamanho--
        return valor
    }

    // Método para verificar o elemento no topo da pilha
    fun peek(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        return topo?.valor
    }

    // Método para verificar se a pilha está vazia
    fun isEmpty(): Boolean {
        return topo == null
    }

    // Método para verificar o tamanho atual da pilha
    fun size(): Int {
        return tamanho
    }

    // Método para esvaziar a pilha
    fun clear() {
        topo = null
        tamanho = 0
    }
}

fun main() {
    val pilha = PilhaDinamica()

    // Testando os métodos
    println("A pilha está vazia? ${pilha.isEmpty()}") // true

    pilha.push(10)
    pilha.push(20)
    pilha.push(30)
    pilha.push(40)
    pilha.push(50)

    println("Elemento no topo: ${pilha.peek()}") // 50
    println("Tamanho da pilha: ${pilha.size()}") // 5

    println("Desempilhando: ${pilha.pop()}") // 50
    println("Elemento no topo: ${pilha.peek()}") // 40

    println("Esvaziando a pilha...")
    pilha.clear()
    println("A pilha está vazia? ${pilha.isEmpty()}") // true
    println("Tamanho da pilha: ${pilha.size()}") // 0
}
