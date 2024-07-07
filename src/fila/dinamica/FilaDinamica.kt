class FilaDinamica(private val tamanho: Int = 10) : Enfileiravel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            var noTemp = NoDuplo(dado)

            noTemp.anterior = ponteiroFim
            if(!estaVazia())
                ponteiroFim?.proximo = noTemp
            else
                ponteiroInicio?.proximo = noTemp
            
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        } else {
            println("Queue is full!")
        }
    }

    override fun atualizar(): Any? {
        if(!estaVazia()) 
            ponteiroInicio?.dado = dado
        else
            println("Queue is empty!")        
    }

    override fun desenfileirar(): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			dadoAux = ponteiroInicio?.dado
			ponteiroInicio = ponteiroInicio?.proximo
			quantidade = quantidade.dec()
			if (!estaVazia())
				ponteiroInicio?.anterior = null
			else
				ponteiroFim = null
		} else {
			println("Fila Vazia!")
		}
		return dadoAux
	}

    override fun frente(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia())
            dadoAux = ponteiroInicio?.dado
        else
            println("Queue empty!")
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade = 0
    }

    override fun imprimir(): String {
		var ponteiroAuxiliar = ponteiroInicio
		var resultado = "["
		for (i in 0 until quantidade) {
			resultado += "${ponteiroAuxiliar?.dado}"
			if (i != quantidade-1)
				resultado += ","
			
			ponteiroAuxiliar = ponteiroAuxiliar?.proximo
		}
		return "$resultado]"
	}
}