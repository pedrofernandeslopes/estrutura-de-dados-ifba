data class Entry<K, V>(val key: K, var value: V)

class HashTable<K, V>(private val capacity: Int = 16) {
    private val table: Array<MutableList<Entry<K, V>>?> = arrayOfNulls(capacity)

    private fun hash(key: K): Int {
        return key.hashCode() % capacity
    }

    fun put(key: K, value: V) {
        val index = hash(key)
        if (table[index] == null) {
            table[index] = mutableListOf()
        }

        val bucket = table[index]!!
        for (entry in bucket) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }

        bucket.add(Entry(key, value))
    }

    fun get(key: K): V? {
        val index = hash(key)
        val bucket = table[index] ?: return null

        for (entry in bucket) {
            if (entry.key == key) {
                return entry.value
            }
        }

        return null
    }

    fun remove(key: K): Boolean {
        val index = hash(key)
        val bucket = table[index] ?: return false

        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.key == key) {
                iterator.remove()
                return true
            }
        }

        return false
    }

    fun containsKey(key: K): Boolean {
        return get(key) != null
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
    val hashTable = HashTable<String, Int>()
    hashTable.put("One", 1)
    hashTable.put("Two", 2)
    hashTable.put("Three", 3)

    println(hashTable.get("One")) // Output: 1
    println(hashTable.get("Two")) // Output: 2
    println(hashTable.get("Four")) // Output: null

    println(hashTable.containsKey("Three")) // Output: true
    println(hashTable.containsKey("Four")) // Output: false

    hashTable.remove("Two")
    println(hashTable.get("Two")) // Output: null

    println("Size: ${hashTable.size()}") // Output: Size: 2
    println("Is Empty: ${hashTable.isEmpty()}") // Output: Is Empty: false

    hashTable.remove("One")
    hashTable.remove("Three")
    println("Is Empty: ${hashTable.isEmpty()}") // Output: Is Empty: true
}
