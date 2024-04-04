// Verificar se todos os elementos de um array são pares.

fun main() {
    val numeros = arrayOf(3, 4, 6, 8, 10)
    var todosPares = true
    for (numero in numeros) {
        if (numero % 2 != 0) {
            todosPares = false
            break
        }
    }
    if (todosPares) {
        println("Todos os números são pares.")
    } else {
        println("Pelo menos um número não é par.")
    }
}
