interface Enfileiravel {
    //Métodos Principais
    fun enfileirar(dado: Any?)
    fun atualizar(dado: Any?)
    fun desenfileirar(): Any?
    fun frente(): Any?

    //Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String    
}