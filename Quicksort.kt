fun quickSort(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)

        // Recursively sort elements before and after partition
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1 // index of smaller element

    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            // Swap arr[i] and arr[j]
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    // Swap arr[i + 1] and arr[high] (or pivot)
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1
}

fun main() {
    val arr = arrayOf(10, 7, 8, 9, 1, 5)
    val n = arr.size
    quickSort(arr, 0, n - 1)
    println("Sorted array: ${arr.joinToString(", ")}")
}
