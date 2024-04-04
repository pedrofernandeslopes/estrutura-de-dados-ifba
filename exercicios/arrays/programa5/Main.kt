// Encontrar a média dos elementos em um array de números inteiros.

fun main() {
    val numeros = arrayOf(10, 20, 30, 40, 50)
    var soma = 0
    for (numero in numeros) {
        soma += numero
    }
    val media = soma / numeros.size.toDouble()
    println("A média dos números é: $media")
}
