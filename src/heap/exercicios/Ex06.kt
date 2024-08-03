data class Elemento(val valor: Int, val prioridade: Int)

class MinPriorityQueue {
    private val heap = mutableListOf<Elemento>()

    // Método para adicionar um elemento à fila de prioridade
    fun enqueue(elemento: Int, prioridade: Int) {
        heap.add(Elemento(elemento, prioridade))
        subir(heap.size - 1)
    }

    // Método para remover e retornar o elemento com menor prioridade
    fun dequeue(): Int? {
        if (heap.isEmpty()) return null
        val menorPrioridade = heap[0].valor
        val ultimo = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) {
            heap[0] = ultimo
            descer(0)
        }
        return menorPrioridade
    }

    // Método para obter o elemento com menor prioridade sem removê-lo
    fun peek(): Int? {
        return heap.firstOrNull()?.valor
    }

    // Método para imprimir a fila de prioridade
    fun imprimirFila() {
        println(heap.sortedBy { it.prioridade })
    }

    // Função auxiliar para manter a propriedade do heap subindo um elemento
    private fun subir(index: Int) {
        var i = index
        while (i > 0) {
            val pai = (i - 1) / 2
            if (heap[i].prioridade >= heap[pai].prioridade) break
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
            var menor = i
            if (esquerda < tamanho && heap[esquerda].prioridade < heap[menor].prioridade) menor = esquerda
            if (direita < tamanho && heap[direita].prioridade < heap[menor].prioridade) menor = direita
            if (menor == i) break
            heap.swap(i, menor)
            i = menor
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
    val minPriorityQueue = MinPriorityQueue()

    // Adicionando elementos à fila de prioridade
    minPriorityQueue.enqueue(10, 2)
    minPriorityQueue.enqueue(5, 5)
    minPriorityQueue.enqueue(15, 1)
    minPriorityQueue.enqueue(3, 10)

    // Imprimindo a fila de prioridade
    println("Fila de prioridade:")
    minPriorityQueue.imprimirFila()

    // Removendo e exibindo o elemento com menor prioridade
    val menorPrioridade = minPriorityQueue.dequeue()
    println("Elemento com menor prioridade removido: $menorPrioridade")

    // Imprimindo a fila de prioridade após remoção
    println("Fila de prioridade após remoção:")
    minPriorityQueue.imprimirFila()

    // Obtendo o elemento com menor prioridade sem removê-lo
    val prioridadeAtual = minPriorityQueue.peek()
    println("Elemento com menor prioridade atual: $prioridadeAtual")
}
