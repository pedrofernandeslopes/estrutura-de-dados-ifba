import pilha.estatica.pilhaSimples.Empilhavel
import pilha.estatica.pilhaSimples.PilhaEstatica

fun main(args: Array<String>) {
    var pilha: Empilhavel = PilhaEstatica(7)
    pilha.empilhar("P")
    pilha.empilhar("E")
    println("Topo: ${pilha.espiar()}")
    pilha.empilhar("D")
    pilha.empilhar("R")
    pilha.empilhar("O")
    pilha.empilhar("T")
    println("Topo: ${pilha.espiar()}")
    val conteudo = pilha.desempilhar()
    pilha.desempilhar()
    pilha.empilhar("H")
    pilha.empilhar("A")
    pilha.empilhar("I")
    pilha.atualizar("S")
    pilha.empilhar(pilha.desempilhar())
    pilha.empilhar(conteudo)
    println("Pilha=${pilha.imprimir()}")
}