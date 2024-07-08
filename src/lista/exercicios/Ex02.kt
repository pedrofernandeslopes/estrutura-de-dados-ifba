class NoLista(val valor: Int, var proximo: NoLista? = null)

class ListaDinamica {
    private var cabeca: NoLista? = null
    private var tamanho: Int = 0

    // Método para adicionar um elemento
    fun add(elemento: Int) {
        val novoNo = NoLista(elemento)
        if (cabeca == null) {
            cabeca = novoNo
        } else {
            var atual = cabeca
            while (atual?.proximo != null) {
                atual = atual.proximo
            }
            atual?.proximo = novoNo
        }
        tamanho++
    }

    // Método para remover um elemento
    fun remove(elemento: Int): Boolean {
        if (cabeca == null) return false

        if (cabeca?.valor == elemento) {
            cabeca = cabeca?.proximo
            tamanho--
            return true
        }

        var atual = cabeca
        while (atual?.proximo != null && atual.proximo?.valor != elemento) {
            atual = atual.proximo
        }

        if (atual?.proximo == null) return false

        atual.proximo = atual.proximo?.proximo
        tamanho--
        return true
    }

    // Método para obter um elemento por índice
    fun get(index: Int): Int? {
        if (index < 0 || index >= tamanho) {
            throw IndexOutOfBoundsException("Índice fora dos limites")
        }
        var atual = cabeca
        for (i in 0 until index) {
            atual = atual?.proximo
        }
        return atual?.valor
    }

    // Método para verificar o tamanho atual da lista
    fun size(): Int {
        return tamanho
    }

    // Método para esvaziar a lista
    fun clear() {
        cabeca = null
        tamanho = 0
    }

    // Método para verificar se a lista está vazia
    fun isEmpty(): Boolean {
        return tamanho == 0
    }
}

fun main() {
    val lista = ListaDinamica()

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
