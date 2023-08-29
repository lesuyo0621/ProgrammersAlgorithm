class SumOfMissingNumbers {
    companion object {
        fun solution(numbers: IntArray): Int = (0..9).filter { numbers.indexOf(it) == -1 }.sum()
    }
}

fun main() = println(SumOfMissingNumbers.solution(intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)))