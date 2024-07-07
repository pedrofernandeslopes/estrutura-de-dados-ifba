interface Empilhavel {
    //Métodos Principais
    fun empilhar(dado: Any?)
    fun atualizar(dado: Any?)
    fun desempilhar(): Any?
    fun espiar(): Any?

    //Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}