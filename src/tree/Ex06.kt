// Definição das cores dos nós
enum class Color {
    RED, BLACK
}

// Classe Node representando um nó da Árvore Rubro-Negra
class Node(var key: Int, var color: Color = Color.RED) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

// Classe para a Árvore Rubro-Negra
class RedBlackTree {
    private var root: Node? = null

    // Rotação à esquerda
    private fun leftRotate(x: Node) {
        val y = x.right
        x.right = y?.left

        if (y?.left != null) {
            y.left?.parent = x
        }

        y?.parent = x.parent

        if (x.parent == null) {
            root = y
        } else if (x == x.parent?.left) {
            x.parent?.left = y
        } else {
            x.parent?.right = y
        }

        y?.left = x
        x.parent = y
    }

    // Rotação à direita
    private fun rightRotate(y: Node) {
        val x = y.left
        y.left = x?.right

        if (x?.right != null) {
            x.right?.parent = y
        }

        x?.parent = y.parent

        if (y.parent == null) {
            root = x
        } else if (y == y.parent?.right) {
            y.parent?.right = x
        } else {
            y.parent?.left = x
        }

        x?.right = y
        y.parent = x
    }

    // Inserção na Árvore Rubro-Negra
    fun insert(key: Int) {
        val newNode = Node(key)
        var y: Node? = null
        var x = root

        while (x != null) {
            y = x
            x = if (newNode.key < x.key) {
                x.left
            } else {
                x.right
            }
        }

        newNode.parent = y

        if (y == null) {
            root = newNode // A árvore estava vazia
        } else if (newNode.key < y.key) {
            y.left = newNode
        } else {
            y.right = newNode
        }

        newNode.left = null
        newNode.right = null
        newNode.color = Color.RED

        insertFixUp(newNode)
    }

    // Ajuste da árvore após inserção para manter as propriedades Rubro-Negras
    private fun insertFixUp(z: Node) {
        var z = z
        while (z.parent?.color == Color.RED) {
            if (z.parent == z.parent?.parent?.left) {
                val y = z.parent?.parent?.right
                if (y?.color == Color.RED) {
                    z.parent?.color = Color.BLACK
                    y.color = Color.BLACK
                    z.parent?.parent?.color = Color.RED
                    z = z.parent?.parent!!
                } else {
                    if (z == z.parent?.right) {
                        z = z.parent!!
                        leftRotate(z)
                    }
                    z.parent?.color = Color.BLACK
                    z.parent?.parent?.color = Color.RED
                    rightRotate(z.parent?.parent!!)
                }
            } else {
                val y = z.parent?.parent?.left
                if (y?.color == Color.RED) {
                    z.parent?.color = Color.BLACK
                    y.color = Color.BLACK
                    z.parent?.parent?.color = Color.RED
                    z = z.parent?.parent!!
                } else {
                    if (z == z.parent?.left) {
                        z = z.parent!!
                        rightRotate(z)
                    }
                    z.parent?.color = Color.BLACK
                    z.parent?.parent?.color = Color.RED
                    leftRotate(z.parent?.parent!!)
                }
            }
        }
        root?.color = Color.BLACK
    }

    // Função para exibir a árvore (pré-ordem)
    fun printTree(node: Node? = root, indent: String = "", last: Boolean = true) {
        if (node != null) {
            print(indent)
            if (last) {
                print("R----")
                indent += "   "
            } else {
                print("L----")
                indent += "|  "
            }
            println("${node.key}(${node.color})")
            printTree(node.left, indent, false)
            printTree(node.right, indent, true)
        }
    }
}

// Função principal para testar a Árvore Rubro-Negra
fun main() {
    val rbTree = RedBlackTree()

    val keys = listOf(20, 15, 25, 10, 5, 1, 30)

    for (key in keys) {
        rbTree.insert(key)
    }

    rbTree.printTree()
}
