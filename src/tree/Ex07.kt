// Definição da classe BTreeNode
class BTreeNode(val t: Int, var isLeaf: Boolean) {
    var keys = mutableListOf<Int>()
    var children = mutableListOf<BTreeNode?>()

    // Função para inserir uma nova chave no nó
    fun insertNonFull(key: Int) {
        var i = keys.size - 1

        if (isLeaf) {
            keys.add(0)
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i]
                i--
            }
            keys[i + 1] = key
        } else {
            while (i >= 0 && keys[i] > key) {
                i--
            }
            i++
            if (children[i]!!.keys.size == 2 * t - 1) {
                splitChild(i, children[i]!!)
                if (key > keys[i]) {
                    i++
                }
            }
            children[i]!!.insertNonFull(key)
        }
    }

    // Função para dividir um filho cheio
    fun splitChild(i: Int, y: BTreeNode) {
        val z = BTreeNode(y.t, y.isLeaf)
        for (j in 0 until t - 1) {
            z.keys.add(y.keys.removeAt(t))
        }
        if (!y.isLeaf) {
            for (j in 0 until t) {
                z.children.add(y.children.removeAt(t))
            }
        }
        children.add(i + 1, z)
        keys.add(i, y.keys.removeAt(t - 1))
    }
}

// Definição da classe BTree
class BTree(val t: Int) {
    var root: BTreeNode? = null

    // Função para inserir uma chave na árvore
    fun insert(key: Int) {
        if (root == null) {
            root = BTreeNode(t, true)
            root!!.keys.add(key)
        } else {
            if (root!!.keys.size == 2 * t - 1) {
                val s = BTreeNode(t, false)
                s.children.add(root)
                s.splitChild(0, root!!)
                root = s
            }
            root!!.insertNonFull(key)
        }
    }

    // Função para imprimir a árvore (traversal em ordem)
    fun traverse() {
        root?.traverse()
    }

    private fun BTreeNode.traverse() {
        for (i in 0 until keys.size) {
            children[i]?.traverse()
            print("${keys[i]} ")
        }
        children[keys.size]?.traverse()
    }
}

// Função principal para testar a Árvore B
fun main() {
    val t = 3 // Grau mínimo
    val tree = BTree(t)

    val keys = listOf(10, 20, 5, 6, 12, 30, 7, 17)
    for (key in keys) {
        tree.insert(key)
    }

    println("Traversal da árvore B:")
    tree.traverse()
}
