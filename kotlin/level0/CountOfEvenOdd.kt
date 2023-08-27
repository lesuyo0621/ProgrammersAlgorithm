class CountOfEvenOdd {
    companion object {
        fun solution(num_list: IntArray): IntArray {
            var answer: IntArray = intArrayOf(0, 0)

            (0..num_list.size - 1).forEach{ if(num_list[it] % 2 == 0) answer[0]++ else answer[1]++ }

            return answer
        }
    }
}

fun main() = println(CountOfEvenOdd.solution(intArrayOf(1, 2, 3, 4, 5)).contentToString())