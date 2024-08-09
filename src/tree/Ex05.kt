// Classe Node para representar os nós da árvore binária
class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}

// Função para encontrar o menor valor em uma árvore binária de busca (BST)
fun findMinValue(node: Node?): Int? {
    var current = node
    while (current?.left != null) {
        current = current.left
    }
    return current?.value
}

// Função para encontrar o maior valor em uma árvore binária de busca (BST)
fun findMaxValue(node: Node?): Int? {
    var current = node
    while (current?.right != null) {
        current = current.right
    }
    return current?.value
}

// Função principal para testar o código
fun main() {
    // Construção de uma árvore binária de busca (BST)
    val root = Node(20)
    root.left = Node(10)
    root.right = Node(30)
    root.left?.left = Node(5)
    root.left?.right = Node(15)
    root.right?.right = Node(40)

    // Encontrando o menor valor na BST
    val minValue = findMinValue(root)
    println("O menor valor na árvore é: $minValue")

    // Encontrando o maior valor na BST
    val maxValue = findMaxValue(root)
    println("O maior valor na árvore é: $maxValue")
}
