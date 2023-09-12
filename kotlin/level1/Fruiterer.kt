class Fruiterer {
    companion object {
        fun solution(k: Int, m: Int, score: IntArray): Int = score.sortedDescending().chunked(m).filter { it.size == m }.map { it[m - 1] * m }.sum()
    }
}

fun main() = println(Fruiterer.solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))