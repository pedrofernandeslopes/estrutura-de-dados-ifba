class FilaEstatica(private val tamanho: Int) {
    private val elementos: Array<Int?> = arrayOfNulls<Int?>(tamanho)
    private var frente: Int = 0
    private var tras: Int = -1
    private var quantidade: Int = 0

    // Método para enfileirar um elemento
    fun enqueue(elemento: Int) {
        if (isFull()) {
            throw IllegalStateException("A fila está cheia")
        }
        tras = (tras + 1) % tamanho
        elementos[tras] = elemento
        quantidade++
    }

    // Método para desenfileirar um elemento
    fun dequeue(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A fila está vazia")
        }
        val elemento = elementos[frente]
        elementos[frente] = null
        frente = (frente + 1) % tamanho
        quantidade--
        return elemento
    }

    // Método para verificar o elemento na frente da fila
    fun peek(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A fila está vazia")
        }
        return elementos[frente]
    }

    // Método para verificar se a fila está vazia
    fun isEmpty(): Boolean {
        return quantidade == 0
    }

    // Método para verificar se a fila está cheia
    fun isFull(): Boolean {
        return quantidade == tamanho
    }

    // Método para verificar o tamanho atual da fila
    fun size(): Int {
        return quantidade
    }

    // Método para esvaziar a fila
    fun clear() {
        for (i in 0 until tamanho) {
            elementos[i] = null
        }
        frente = 0
        tras = -1
        quantidade = 0
    }
}

fun main() {
    val fila = FilaEstatica(5)

    // Testando os métodos
    println("A fila está vazia? ${fila.isEmpty()}") // true

    fila.enqueue(10)
    fila.enqueue(20)
    fila.enqueue(30)
    fila.enqueue(40)
    fila.enqueue(50)

    println("A fila está cheia? ${fila.isFull()}") // true

    println("Elemento na frente: ${fila.peek()}") // 10
    println("Tamanho da fila: ${fila.size()}") // 5

    println("Desenfileirando: ${fila.dequeue()}") // 10
    println("Elemento na frente: ${fila.peek()}") // 20

    println("Esvaziando a fila...")
    fila.clear()
    println("A fila está vazia? ${fila.isEmpty()}") // true
    println("Tamanho da fila: ${fila.size()}") // 0
}
