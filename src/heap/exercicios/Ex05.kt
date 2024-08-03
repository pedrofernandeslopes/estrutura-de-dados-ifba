data class Elemento(val valor: Int, val prioridade: Int)

class PriorityQueue {
    private val heap = mutableListOf<Elemento>()

    // Método para adicionar um elemento à fila de prioridade
    fun enqueue(elemento: Int, prioridade: Int) {
        heap.add(Elemento(elemento, prioridade))
        subir(heap.size - 1)
    }

    // Método para remover e retornar o elemento com maior prioridade
    fun dequeue(): Int? {
        if (heap.isEmpty()) return null
        val maiorPrioridade = heap[0].valor
        val ultimo = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) {
            heap[0] = ultimo
            descer(0)
        }
        return maiorPrioridade
    }

    // Método para obter o elemento com maior prioridade sem removê-lo
    fun peek(): Int? {
        return heap.firstOrNull()?.valor
    }

    // Método para imprimir a fila de prioridade
    fun imprimirFila() {
        println(heap.sortedByDescending { it.prioridade })
    }

    // Função auxiliar para manter a propriedade do heap subindo um elemento
    private fun subir(index: Int) {
        var i = index
        while (i > 0) {
            val pai = (i - 1) / 2
            if (heap[i].prioridade <= heap[pai].prioridade) break
            heap.swap(i, pai)
            i = pai
        }
    }

    // Função auxiliar para manter a propriedade do heap descendo um elemento
    private fun descer(index: Int) {
        var i = index
        val tamanho = heap.size
        while (true) {
            val esquerda = 2 * i + 1
            val direita = 2 * i + 2
            var maior = i
            if (esquerda < tamanho && heap[esquerda].prioridade > heap[maior].prioridade) maior = esquerda
            if (direita < tamanho && heap[direita].prioridade > heap[maior].prioridade) maior = direita
            if (maior == i) break
            heap.swap(i, maior)
            i = maior
        }
    }

    // Função auxiliar para trocar elementos na lista
    private fun MutableList<Elemento>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

fun main() {
    val priorityQueue = PriorityQueue()

    // Adicionando elementos à fila de prioridade
    priorityQueue.enqueue(10, 2)
    priorityQueue.enqueue(5, 5)
    priorityQueue.enqueue(15, 1)
    priorityQueue.enqueue(3, 10)

    // Imprimindo a fila de prioridade
    println("Fila de prioridade:")
    priorityQueue.imprimirFila()

    // Removendo e exibindo o elemento com maior prioridade
    val maiorPrioridade = priorityQueue.dequeue()
    println("Elemento com maior prioridade removido: $maiorPrioridade")

    // Imprimindo a fila de prioridade após remoção
    println("Fila de prioridade após remoção:")
    priorityQueue.imprimirFila()

    // Obtendo o elemento com maior prioridade sem removê-lo
    val prioridadeAtual = priorityQueue.peek()
    println("Elemento com maior prioridade atual: $prioridadeAtual")
}
