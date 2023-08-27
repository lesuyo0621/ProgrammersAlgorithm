class SliceArray {
    companion object {
        fun solution(numbers: IntArray, start: Int, end: Int): IntArray = numbers.sliceArray(start..end)
    }
}

fun main() = println(SliceArray.solution(intArrayOf(1, 2, 3, 4, 5), 1, 3).contentToString())