// Calcular a soma de todos os elementos de um array de números inteiros.

fun main() {
    val numeros = arrayOf(1, 2, 3, 4, 5)
    var soma = 0
    for (numero in numeros) {
        soma += numero
    }
    println("A soma dos números é: $soma")
}
