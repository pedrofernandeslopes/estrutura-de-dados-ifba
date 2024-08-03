class MinHeap {
    private val heap = mutableListOf<Int>()

    // Método para inserir um elemento no heap
    fun inserir(elemento: Int) {
        heap.add(elemento)
        subir(heap.size - 1)
    }

    // Método para remover o menor elemento do heap (raiz)
    fun removerMinimo(): Int? {
        if (heap.isEmpty()) return null
        val min = heap[0]
        val ultimo = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) {
            heap[0] = ultimo
            descer(0)
        }
        return min
    }

    // Método para obter o menor elemento do heap sem removê-lo
    fun minimo(): Int? {
        return heap.firstOrNull()
    }

    // Método para imprimir o heap
    fun imprimirHeap() {
        println(heap)
    }

    // Função auxiliar para manter a propriedade do heap subindo um elemento
    private fun subir(index: Int) {
        var i = index
        while (i > 0) {
            val pai = (i - 1) / 2
            if (heap[i] >= heap[pai]) break
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
            if (esquerda < tamanho && heap[esquerda] < heap[menor]) menor = esquerda
            if (direita < tamanho && heap[direita] < heap[menor]) menor = direita
            if (menor == i) break
            heap.swap(i, menor)
            i = menor
        }
    }

    // Função auxiliar para trocar elementos na lista
    private fun MutableList<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

fun main() {
    val minHeap = MinHeap()

    // Inserindo elementos no heap
    minHeap.inserir(10)
    minHeap.inserir(5)
    minHeap.inserir(15)
    minHeap.inserir(3)

    // Imprimindo o heap
    println("Heap após inserções:")
    minHeap.imprimirHeap()

    // Removendo o mínimo
    val minimoRemovido = minHeap.removerMinimo()
    println("Menor elemento removido: $minimoRemovido")

    // Imprimindo o heap após remoção
    println("Heap após remoção do mínimo:")
    minHeap.imprimirHeap()

    // Obtendo o mínimo sem remover
    val minimoAtual = minHeap.minimo()
    println("Menor elemento atual: $minimoAtual")
}
