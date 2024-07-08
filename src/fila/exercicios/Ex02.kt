class NoFila(val valor: Int, var proximo: NoFila? = null)

class FilaDinamica {
    private var frente: NoFila? = null
    private var tras: NoFila? = null
    private var tamanho: Int = 0

    // Método para enfileirar um elemento
    fun enqueue(elemento: Int) {
        val novoNo = NoFila(elemento)
        if (isEmpty()) {
            frente = novoNo
            tras = novoNo
        } else {
            tras?.proximo = novoNo
            tras = novoNo
        }
        tamanho++
    }

    // Método para desenfileirar um elemento
    fun dequeue(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A fila está vazia")
        }
        val valor = frente?.valor
        frente = frente?.proximo
        if (frente == null) {
            tras = null
        }
        tamanho--
        return valor
    }

    // Método para verificar o elemento na frente da fila
    fun peek(): Int? {
        if (isEmpty()) {
            throw NoSuchElementException("A fila está vazia")
        }
        return frente?.valor
    }

    // Método para verificar se a fila está vazia
    fun isEmpty(): Boolean {
        return frente == null
    }

    // Método para verificar o tamanho atual da fila
    fun size(): Int {
        return tamanho
    }

    // Método para esvaziar a fila
    fun clear() {
        frente = null
        tras = null
        tamanho = 0
    }
}

fun main() {
    val fila = FilaDinamica()

    // Testando os métodos
    println("A fila está vazia? ${fila.isEmpty()}") // true

    fila.enqueue(10)
    fila.enqueue(20)
    fila.enqueue(30)
    fila.enqueue(40)
    fila.enqueue(50)

    println("Elemento na frente: ${fila.peek()}") // 10
    println("Tamanho da fila: ${fila.size()}") // 5

    println("Desenfileirando: ${fila.dequeue()}") // 10
    println("Elemento na frente: ${fila.peek()}") // 20

    println("Esvaziando a fila...")
    fila.clear()
    println("A fila está vazia? ${fila.isEmpty()}") // true
    println("Tamanho da fila: ${fila.size()}") // 0
}
