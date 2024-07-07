fun main(args: Array<String>) {
    var pilha: Empilhavel = PilhaInvertida(7)
    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println("Topo: ${pilha.espiar()}")
    pilha.empilhar("de")
    pilha.empilhar("Educação")
    pilha.empilhar("Ciência")
    pilha.empilhar("e")
    println("Topo: ${pilha.espiar()}")
    println("Pilha=${pilha.imprimir()}")
}