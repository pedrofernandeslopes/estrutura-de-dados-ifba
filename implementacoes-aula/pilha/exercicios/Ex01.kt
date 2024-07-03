class Stack(private val size: Int) {
    private val arr: IntArray = IntArray(size)
    private var top: Int = - 1

    // Adiciona elementos na pilha
    fun push(x: Int) {
        if (isFull()) {
            println("OverFlow\nProgram Terminarted\n")
            System.exit(1)
        }
        println("Inserting $x")
        arr[++top] = x
    }

     // Remove elemento da pilha
     fun pop(): Int {
        if (isEmpty()) {
            println("STACK EMPTY")
        }
        return arr[top--]
     }

    // Função utilitária para retornar o tamanho da pilha
    fun size(): Int {
        return top + 1
    }

     // Verifica se a pilha está vazia
     fun isEmpty(): Boolean {
        return top == -1
     }

     // Verifica se a pilha está cheia
     fun isFull(): Boolean {
        return top == size - 1
     }

     fun printStack() {
        for (i in 0..top) {
            println(arr[i])
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stack = Stack(5)

            stack.push(1)
            stack.push(2)
            stack.push(3)
            stack.push(4)

            stack.pop()
            println("\nAfter popping out")

            stack.printStack()
        }
    }
}