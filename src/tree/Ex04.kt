// Classe Node para representar os nós da árvore binária
class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}

// Função para verificar se duas árvores são idênticas
fun areIdentical(root1: Node?, root2: Node?): Boolean {
    if (root1 == null && root2 == null) return true
    if (root1 == null || root2 == null) return false
    return (root1.value == root2.value) &&
            areIdentical(root1.left, root2.left) &&
            areIdentical(root1.right, root2.right)
}

// Função para verificar se T2 é subárvore de T1
fun isSubtree(T1: Node?, T2: Node?): Boolean {
    if (T2 == null) return true
    if (T1 == null) return false
    if (areIdentical(T1, T2)) return true
    return isSubtree(T1.left, T2) || isSubtree(T1.right, T2)
}

// Função principal para testar o código
fun main() {
    // Construção da árvore T1
    val T1 = Node(1)
    T1.left = Node(2)
    T1.right = Node(3)
    T1.left?.left = Node(4)
    T1.left?.right = Node(5)

    // Construção da árvore T2
    val T2 = Node(2)
    T2.left = Node(4)
    T2.right = Node(5)

    // Verificação se T2 é subárvore de T1
    if (isSubtree(T1, T2)) {
        println("T2 é uma subárvore de T1")
    } else {
        println("T2 não é uma subárvore de T1")
    }
}
