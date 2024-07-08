class HashSet<T>(private val capacity: Int = 16) {
    private val table: Array<MutableList<T>?> = arrayOfNulls(capacity)

    private fun hash(value: T): Int {
        return value.hashCode() % capacity
    }

    fun add(value: T) {
        val index = hash(value)
        if (table[index] == null) {
            table[index] = mutableListOf()
        }

        val bucket = table[index]!!
        if (!bucket.contains(value)) {
            bucket.add(value)
        }
    }

    fun remove(value: T): Boolean {
        val index = hash(value)
        val bucket = table[index] ?: return false

        return bucket.remove(value)
    }

    fun contains(value: T): Boolean {
        val index = hash(value)
        val bucket = table[index] ?: return false

        return bucket.contains(value)
    }

    fun isEmpty(): Boolean {
        return table.all { it.isNullOrEmpty() }
    }

    fun size(): Int {
        var size = 0
        for (bucket in table) {
            if (bucket != null) {
                size += bucket.size
            }
        }
        return size
    }
}

fun main() {
    val hashSet = HashSet<Int>()
    hashSet.add(1)
    hashSet.add(2)
    hashSet.add(3)
    hashSet.add(2) // Duplicate value, should not be added

    println(hashSet.contains(1)) // Output: true
    println(hashSet.contains(4)) // Output: false

    println("Size: ${hashSet.size()}") // Output: Size: 3

    hashSet.remove(2)
    println(hashSet.contains(2)) // Output: false

    println("Size: ${hashSet.size()}") // Output: Size: 2

    hashSet.remove(1)
    hashSet.remove(3)
    println("Is Empty: ${hashSet.isEmpty()}") // Output: Is Empty: true
}
