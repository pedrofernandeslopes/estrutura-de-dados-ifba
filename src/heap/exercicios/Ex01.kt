class MinHeap {
    private val heap = mutableListOf<Int>()

    private fun parent(index: Int) = (index - 1) / 2
    private fun leftChild(index: Int) = 2 * index + 1
    private fun rightChild(index: Int) = 2 * index + 2

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        while (currentIndex > 0 && heap[currentIndex] < heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex))
            currentIndex = parent(currentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (leftChild(currentIndex) < heap.size) {
            var smallerChildIndex = leftChild(currentIndex)
            if (rightChild(currentIndex) < heap.size && heap[rightChild(currentIndex)] < heap[smallerChildIndex]) {
                smallerChildIndex = rightChild(currentIndex)
            }
            if (heap[currentIndex] <= heap[smallerChildIndex]) break
            swap(currentIndex, smallerChildIndex)
            currentIndex = smallerChildIndex
        }
    }

    fun insert(value: Int) {
        heap.add(value)
        heapifyUp(heap.size - 1)
    }

    fun remove(): Int? {
        if (heap.isEmpty()) return null
        val result = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) heapifyDown(0)
        return result
    }

    fun peek(): Int? {
        return if (heap.isEmpty()) null else heap[0]
    }

    fun isEmpty() = heap.isEmpty()
}

fun main() {
    val minHeap = MinHeap()
    minHeap.insert(10)
    minHeap.insert(5)
    minHeap.insert(14)
    minHeap.insert(2)

    println(minHeap.peek()) // Output: 2
    println(minHeap.remove()) // Output: 2
    println(minHeap.peek()) // Output: 5
    println(minHeap.remove()) // Output: 5
    println(minHeap.peek()) // Output: 10
    println(minHeap.remove()) // Output: 10
    println(minHeap.peek()) // Output: 14
    println(minHeap.remove()) // Output: 14
    println(minHeap.peek()) // Output: null
}
