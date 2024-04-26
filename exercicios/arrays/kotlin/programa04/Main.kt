// Verificar se um determinado número está presente em um array de números inteiros.

fun main() {
    val numeros = arrayOf(1, 2, 3, 4, 5)
    val numeroProcurado = 3
    var encontrado = false

    for (numero in numeros) {
        if (numero == numeroProcurado) {
            encontrado = true
            break
        }
    }

    if (encontrado) {
        println("$numeroProcurado está presente no array.")
    } else {
        println("$numeroProcurado não está presente no array.")
    }
}
