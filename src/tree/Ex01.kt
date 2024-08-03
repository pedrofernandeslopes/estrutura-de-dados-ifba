class BinarySearchTree {

    // Classe interna para representar um nó da árvore
    inner class Node(val value: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    private var root: Node? = null

    // Método para inserir um valor na árvore
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value)
        } else if (value > node.value) {
            node.right = insertRec(node.right, value)
        }
        return node
    }

    // Método para buscar um valor na árvore
    fun search(value: Int): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(node: Node?, value: Int): Boolean {
        if (node == null) {
            return false
        }
        if (value == node.value) {
            return true
        }
        return if (value < node.value) {
            searchRec(node.left, value)
        } else {
            searchRec(node.right, value)
        }
    }

    // Método para realizar a travessia em ordem e imprimir os valores
    fun inOrderTraversal() {
        inOrderRec(root)
        println()
    }

    private fun inOrderRec(node: Node?) {
        if (node != null) {
            inOrderRec(node.left)
            print("${node.value} ")
            inOrderRec(node.right)
        }
    }
}

fun main() {
    val bst = BinarySearchTree()

    // Inserindo valores na árvore
    bst.insert(50)
    bst.insert(30)
    bst.insert(70)
    bst.insert(20)
    bst.insert(40)
    bst.insert(60)
    bst.insert(80)

    // Imprimindo a travessia em ordem
    println("Travessia em ordem:")
    bst.inOrderTraversal()

    // Buscando valores na árvore
    println("Busca pelo valor 40: ${bst.search(40)}")
    println("Busca pelo valor 90: ${bst.search(90)}")
}
