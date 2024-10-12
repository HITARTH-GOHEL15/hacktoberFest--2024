fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }

    // Split the array into two halves
    val middle = arr.size / 2
    val left = arr.sliceArray(0 until middle)
    val right = arr.sliceArray(middle until arr.size)

    // Recursively sort each half
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: IntArray, right: IntArray): IntArray {
    var leftIndex = 0
    var rightIndex = 0
    val result = mutableListOf<Int>()

    // Compare elements from left and right arrays and merge them in sorted order
    while (leftIndex < left.size && rightIndex < right.size) {
        if (left[leftIndex] <= right[rightIndex]) {
            result.add(left[leftIndex])
            leftIndex++
        } else {
            result.add(right[rightIndex])
            rightIndex++
        }
    }

    // Append any remaining elements from the left array
    while (leftIndex < left.size) {
        result.add(left[leftIndex])
        leftIndex++
    }

    // Append any remaining elements from the right array
    while (rightIndex < right.size) {
        result.add(right[rightIndex])
        rightIndex++
    }

    return result.toIntArray()
}

fun main() {
    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    val sortedArray = mergeSort(arr)
    println("Sorted Array: ${sortedArray.joinToString(", ")}")
}
