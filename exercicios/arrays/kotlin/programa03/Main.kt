// Encontrar o maior número em um array de números inteiros

fun main() {
    val numeros = arrayOf(9, 40, 30, 66, 68, 98)

    var maior = numeros[0]

    for (numero in numeros) {
        if (numero > maior) {
            maior = numero
        }
    }
    println("O maior número é : $maior")
}