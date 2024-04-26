interface Empilhavel {
    //Métodos Principais
    fun empilhar(dado: Any?)     //C
    fun atualizar(dado: Any?)    //U
    fun desempilhar(): Any?      //D
    fun espiar(): Any?           //R


    //Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}