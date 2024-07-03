fun main(args: Array<String>) {
    var pilha: Empilhavel = PilhaEstatica(7)
    pilha.empilhar("Pedro")
    pilha.empilhar("Fernandes")
    println("Topo: ${pilha.espiar()}")
    pilha.empilhar("Lopes")
    pilha.empilhar("Thais")
    pilha.empilhar("de Melo")
    pilha.empilhar("Costa")
    println("Topo: ${pilha.espiar()}")
    val conteudo = pilha.desempilhar()
    pilha.desempilhar()
    println("Pilha=${pilha.imprimir()}")

}