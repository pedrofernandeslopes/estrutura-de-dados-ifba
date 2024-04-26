class PilhaEstatica : Empilhavel {
	private var ponteiroTopo: Int
	private var dados: Array<Any?>

	constructor(tamanho: Int) {
		ponteiroTopo = -1
		dados = arrayOfNulls(tamanho)
	}

	constructor() : this(10)

	override fun empilhar(dado: Any?) {
		if(!estaCheia()) {
			ponteiroTopo++
			dados[ponteiroTopo] = dados
		} else {
			println("Stack is full!")
		}
	}

	overrive fun atualizar(dado: Any?) {
		if(!estaVazia()) {
			dados[ponteiroTopo] = dado
		} else {
			println("Stack is empty!")
		}
	}

	override fun desempilhar(): Any? {
		var dadoTopo : Any? = null
		if(!estaVazia()) {
			dadoTopo = dados[ponteiroTopo]
			ponteiroTopo--
		} else {
			println("Stack is empty!")
		}
	}

	override fun espiar(): Any? {
		var dadoTopo : Any? = null
		if(!estaVazia()) {
			dadoTopo = dados[ponteiroTopo]
		} else {
			println("Stack is empty!")
		}
	}

	override fun estaCheia(): Boolean {
		return(ponteiroTopo == dados.size - 1)
	}

	override fun estaVazia(): Boolean {
		return(ponteiroTopo == -1)
	}

	override fun imprimir(): String {
		var resultado = "["
		for (i in ponteiroTopo downTo 0) {
			if (i == 0) {
				resultado += "${dados[i]}"
			else
				resultado += "$[dados[i], ]"
			} 
		}
		return "$resultado]"
	}
}