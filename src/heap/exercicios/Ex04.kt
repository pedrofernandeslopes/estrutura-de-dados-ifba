import java.util.PriorityQueue

class TopK(private val k: Int) {
    private val maxHeap = PriorityQueue<Int>(k, reverseOrder())

    fun adicionarElemento(elemento: Int) {
        if (maxHeap.size < k) {
            maxHeap.offer(elemento)
        } else if (elemento > maxHeap.peek()) {
            maxHeap.poll()
            maxHeap.offer(elemento)
        }
    }

    fun obterTopK(): List<Int> {
        return maxHeap.sortedDescending()
    }

    fun imprimirTopK() {
        println(obterTopK())
    }
}

fun main() {
    val topK = TopK(3) // Mantém os 3 maiores elementos

    // Adicionando elementos
    topK.adicionarElemento(10)
    topK.adicionarElemento(5)
    topK.adicionarElemento(15)
    topK.adicionarElemento(3)
    topK.adicionarElemento(20)
    topK.adicionarElemento(8)

    // Imprimindo os top K elementos
    println("Top 3 maiores elementos:")
    topK.imprimirTopK()
}
