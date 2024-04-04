// 1. Faça um Programa que leia um vetor de 5 números inteiros e mostre-os.

fun main() {
    // Criando um vetor de tamanho 5 para armazenar os números inteiros
    val vetor = IntArray(5)

    // Solicitando ao usuário que insira os números inteiros
    println("Digite 5 números inteiros:")
    
    // Lendo os números e armazenando-os no vetor
    for (i in 0 until 5) {
        print("Número ${i + 1}: ")
        vetor[i] = readLine()!!.toInt()
    }

    // Exibindo os números do vetor
    println("Os números digitados são:")
    for (numero in vetor) {
        println(numero)
    }
}
