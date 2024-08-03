class ContatoManager {
    private val contatos = mutableMapOf<String, String>()

    fun adicionarContato(nome: String, telefone: String) {
        contatos[nome] = telefone
        println("Contato '$nome' adicionado com sucesso.")
    }

    fun removerContato(nome: String) {
        if (contatos.remove(nome) != null) {
            println("Contato '$nome' removido com sucesso.")
        } else {
            println("Contato '$nome' não encontrado.")
        }
    }

    fun obterTelefone(nome: String): String? {
        return contatos[nome]
    }

    fun listarContatos(): List<String> {
        return contatos.map { (nome, telefone) -> "$nome: $telefone" }
    }
}

fun main() {
    val contatoManager = ContatoManager()

    // Adicionando contatos
    contatoManager.adicionarContato("João", "1234-5678")
    contatoManager.adicionarContato("Maria", "8765-4321")

    // Listando contatos
    println("Contatos:")
    contatoManager.listarContatos().forEach { println(it) }

    // Obtendo telefone
    val telefoneJoao = contatoManager.obterTelefone("João")
    println("Telefone de João: $telefoneJoao")

    // Removendo contato
    contatoManager.removerContato("Maria")
    println("Contatos após remoção:")
    contatoManager.listarContatos().forEach { println(it) }
}
