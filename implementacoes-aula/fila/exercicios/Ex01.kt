class Queue {
    private val SIZE = 5
    private val items = IntArray(SIZE)
    private var front = -1
    private var rear = -1

    fun isFull(): Boolean {
        return front == 0 && rear == SIZE - 1
    }

    fun isEmpty(): Boolean {
        return front == -1
    }

    fun enQueue(element: Int) {
        if (isFull()) {
            println("Queue is full")
        } else {
            if (front == -1)
                front = 0
            rear++
            items[rear] = element
            println("Inserted $element")
        }
    }

    fun deQueue(): Int {
        var element = -1
        if (isEmpty()) {
            println("Queue is empty")
        } else {
            element = items[front]
            if (front >= rear) {
                front = -1
                rear = -1
            } else {
                front++
            }
            println("Deleted -> $element")
        }
        return element
    }

    fun display() {
        if (isEmpty()) {
            println("Empty Queue")
        } else {
            println("\nFront index-> $front")
            print("Items -> ")
            for (i in front..rear) {
                print("${items[i]}  ")
            }
            println("\nRear index-> $rear")
        }
    }
}

fun main() {
    val q = Queue()

    // deQueue is not possible on empty queue
    q.deQueue()

    // enQueue 5 elements
    q.enQueue(1)
    q.enQueue(2)
    q.enQueue(3)
    q.enQueue(4)
    q.enQueue(5)

    // 6th element can't be added to because the queue is full
    q.enQueue(6)

    q.display()

    // deQueue removes element entered first i.e. 1
    q.deQueue()

    // Now we have just 4 elements
    q.display()
}
