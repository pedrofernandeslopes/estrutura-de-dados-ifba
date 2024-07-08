class ListaEstatica(private val tamanho: Int) {
    private val elementos: Array<Int?> = arrayOfNulls<Int?>(tamanho)
    private var quantidade: Int = 0

    // Método para adicionar um elemento
    fun add(elemento: Int) {
        if (quantidade == tamanho) {
            throw IllegalStateException("A lista está cheia")
        }
        elementos[quantidade++] = elemento
    }

    // Método para remover um elemento
    fun remove(elemento: Int): Boolean {
        val index = elementos.indexOf(elemento)
        if (index == -1) {
            return false
        }
        for (i in index until quantidade - 1) {
            elementos[i] = elementos[i + 1]
        }
        elementos[--quantidade] = null
        return true
    }

    // Método para obter um elemento por índice
    fun get(index: Int): Int? {
        if (index < 0 || index >= quantidade) {
            throw IndexOutOfBoundsException("Índice fora dos limites")
        }
        return elementos[index]
    }

    // Método para verificar o tamanho atual da lista
    fun size(): Int {
        return quantidade
    }

    // Método para esvaziar a lista
    fun clear() {
        for (i in 0 until quantidade) {
            elementos[i] = null
        }
        quantidade = 0
    }

    // Método para verificar se a lista está vazia
    fun isEmpty(): Boolean {
        return quantidade == 0
    }
}

fun main() {
    val lista = ListaEstatica(5)

    // Testando os métodos
    println("A lista está vazia? ${lista.isEmpty()}") // true

    lista.add(10)
    lista.add(20)
    lista.add(30)
    lista.add(40)
    lista.add(50)

    println("Elemento no índice 2: ${lista.get(2)}") // 30
    println("Tamanho da lista: ${lista.size()}") // 5

    println("Removendo elemento 30: ${lista.remove(30)}") // true
    println("Elemento no índice 2: ${lista.get(2)}") // 40

    println("Esvaziando a lista...")
    lista.clear()
    println("A lista está vazia? ${lista.isEmpty()}") // true
    println("Tamanho da lista: ${lista.size()}") // 0
}
