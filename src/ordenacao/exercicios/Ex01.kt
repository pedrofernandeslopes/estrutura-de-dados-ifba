fun quickSort(arr: MutableList<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1
}

fun main() {
    val arr = mutableListOf(10, 7, 8, 9, 1, 5)
    println("Array inicial: $arr")
    quickSort(arr, 0, arr.size - 1)
    println("Array ordenado: $arr")
}
