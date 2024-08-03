fun quickSort(lista: MutableList<Int>, inicio: Int, fim: Int) {
    if (inicio < fim) {
        val pivoIndex = particionar(lista, inicio, fim)
        quickSort(lista, inicio, pivoIndex - 1)
        quickSort(lista, pivoIndex + 1, fim)
    }
}

fun particionar(lista: MutableList<Int>, inicio: Int, fim: Int): Int {
    val pivo = lista[fim]
    var i = inicio - 1
    for (j in inicio until fim) {
        if (lista[j] <= pivo) {
            i++
            lista.swap(i, j)
        }
    }
    lista.swap(i + 1, fim)
    return i + 1
}

fun MutableList<Int>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    val lista = mutableListOf(10, 7, 8, 9, 1, 5)

    println("Lista antes da ordenação: $lista")
    quickSort(lista, 0, lista.size - 1)
    println("Lista após a ordenação: $lista")
}
