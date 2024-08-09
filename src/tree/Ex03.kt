import java.util.LinkedList
import java.util.Queue

// Classe Node representando um diretório ou arquivo
class Node(val name: String, val isDirectory: Boolean) {
    val children = mutableListOf<Node>()

    // Adiciona um filho ao nó atual (somente se for um diretório)
    fun addChild(child: Node) {
        if (isDirectory) {
            children.add(child)
        } else {
            println("Não é possível adicionar filhos a um arquivo.")
        }
    }
}

// Função de busca em profundidade (DFS)
fun dfs(node: Node, name: String): Node? {
    if (node.name == name) {
        return node
    }

    for (child in node.children) {
        val result = dfs(child, name)
        if (result != null) {
            return result
        }
    }

    return null
}

// Função de busca em largura (BFS)
fun bfs(root: Node, name: String): Node? {
    val queue: Queue<Node> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        if (node.name == name) {
            return node
        }

        queue.addAll(node.children)
    }

    return null
}

// Função principal para criar a árvore e realizar buscas
fun main() {
    // Criação da árvore
    val root = Node("root", true)
    val folderA = Node("folderA", true)
    val folderB = Node("folderB", true)
    val file1 = Node("file1.txt", false)
    val file2 = Node("file2.txt", false)

    root.addChild(folderA)
    root.addChild(folderB)
    folderA.addChild(file1)
    folderB.addChild(file2)

    // Teste da busca DFS
    val resultDFS = dfs(root, "file1.txt")
    println("DFS: ${resultDFS?.name ?: "Arquivo/Diretório não encontrado"}")

    // Teste da busca BFS
    val resultBFS = bfs(root, "file2.txt")
    println("BFS: ${resultBFS?.name ?: "Arquivo/Diretório não encontrado"}")
}
