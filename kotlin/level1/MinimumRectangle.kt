class MinimumRectangle {
    companion object {
        fun solution(sizes: Array<IntArray>): Int {
            val reSizes: Array<IntArray> = sizes.map {
                if (it[1] > it[0]) {
                    val temp = it[0]
                    it[0] = it[1]
                    it[1] = temp
                }
                it
            }.toTypedArray()

            val max0: Int = reSizes.map { it[0] }.maxOf { it }
            val max1: Int = reSizes.map { it[1] }.maxOf { it }

            return max0 * max1
        }
    }
}

fun main() = println(MinimumRectangle.solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))))