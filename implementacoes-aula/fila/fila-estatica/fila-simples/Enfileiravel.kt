interface Enfileiravel {
    //Métodos Principais
    fun enfileirar(dado: Any?)  //C
    fun atualizar(dado: Any?)   //U
    fun desenfileirar(): Any?   //D
    fun frente(): Any?          //R


    //Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}