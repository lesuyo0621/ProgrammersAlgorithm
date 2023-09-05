import java.util.PriorityQueue

class HallOfFame1 {
    companion object {
        fun solution(k: Int, score: IntArray): IntArray {
            val queue = PriorityQueue<Int>()
            val array = IntArray(score.size)

            score.indices.forEach {
                queue.add(score[it])
                if(queue.size > k) queue.poll()

                array[it] = queue.peek()
            }

            return array
        }
    }
}

fun main() = println(HallOfFame1.solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).contentToString())