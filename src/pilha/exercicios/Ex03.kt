class NoDuplo(val valor: Int, var proximo: NoDuplo? = null, var anterior: NoDuplo? = null)

class PilhaDuplamenteEncadeada {
    private var topo: NoDuplo? = null
    private var base: NoDuplo? = null
    private var tamanho: Int = 0

    // Método para empilhar um elemento
    fun push(elemento: Int) {
        val novoNo = NoDuplo(elemento)
        if (isEmpty()) {
            topo = novoNo
            base = novoNo
        } else {
            novoNo.anterior = topo
            topo?.proximo = novoNo
            topo = novoNo
        }
        tamanho++
    }

    // Método para desempilhar um elemento
    fun pop(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        val valor = topo?.valor
        if (topo == base) {
            topo = null
            base = null
        } else {
            topo = topo?.anterior
            topo?.proximo = null
        }
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
        return tamanho == 0
    }

    // Método para verificar o tamanho atual da pilha
    fun size(): Int {
        return tamanho
    }

    // Método para esvaziar a pilha
    fun clear() {
        topo = null
        base = null
        tamanho = 0
    }

    // Método para obter o elemento na base da pilha
    fun peekBase(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A pilha está vazia")
        }
        return base?.valor
    }
}

fun main() {
    val pilha = PilhaDuplamenteEncadeada()

    // Testando os métodos
    println("A pilha está vazia? ${pilha.isEmpty()}") // true

    pilha.push(10)
    pilha.push(20)
    pilha.push(30)
    pilha.push(40)
    pilha.push(50)

    println("Elemento no topo: ${pilha.peek()}") // 50
    println("Elemento na base: ${pilha.peekBase()}") // 10
    println("Tamanho da pilha: ${pilha.size()}") // 5

    println("Desempilhando: ${pilha.pop()}") // 50
    println("Elemento no topo: ${pilha.peek()}") // 40

    println("Esvaziando a pilha...")
    pilha.clear()
    println("A pilha está vazia? ${pilha.isEmpty()}") // true
    println("Tamanho da pilha: ${pilha.size()}") // 0
}
