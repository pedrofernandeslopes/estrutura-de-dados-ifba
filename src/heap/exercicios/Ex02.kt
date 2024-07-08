class MaxHeap {
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
        while (currentIndex > 0 && heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex))
            currentIndex = parent(currentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (leftChild(currentIndex) < heap.size) {
            var largerChildIndex = leftChild(currentIndex)
            if (rightChild(currentIndex) < heap.size && heap[rightChild(currentIndex)] > heap[largerChildIndex]) {
                largerChildIndex = rightChild(currentIndex)
            }
            if (heap[currentIndex] >= heap[largerChildIndex]) break
            swap(currentIndex, largerChildIndex)
            currentIndex = largerChildIndex
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

fun findKthLargest(nums: List<Int>, k: Int): Int? {
    val maxHeap = MaxHeap()
    for (num in nums) {
        maxHeap.insert(num)
    }
    var result: Int? = null
    for (i in 1..k) {
        result = maxHeap.remove()
    }
    return result
}

fun main() {
    val nums = listOf(3, 2, 1, 5, 6, 4)
    val k = 2
    val kthLargest = findKthLargest(nums, k)
    println("O ${k}º maior elemento é: $kthLargest") // Output: O 2º maior elemento é: 5
}
