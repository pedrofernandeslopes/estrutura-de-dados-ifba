fun mergeSort(arr: MutableList<Int>): MutableList<Int> {
    if (arr.size <= 1) {
        return arr
    }

    val middle = arr.size / 2
    val left = arr.subList(0, middle)
    val right = arr.subList(middle, arr.size)

    return merge(mergeSort(left.toMutableList()), mergeSort(right.toMutableList()))
}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    var indexLeft = 0
    var indexRight = 0
    val newList = mutableListOf<Int>()

    while (indexLeft < left.size && indexRight < right.size) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }

    return newList
}

fun main() {
    val arr = mutableListOf(38, 27, 43, 3, 9, 82, 10)
    println("Array inicial: $arr")
    val sortedArray = mergeSort(arr)
    println("Array ordenado: $sortedArray")
}
