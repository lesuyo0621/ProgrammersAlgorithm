class CompletionOfTriangle {
    companion object {
        fun solution(sides: IntArray): Int {
            val max: Int = sides.maxOrNull()!!
            val sum: Int = sides.filterIndexed{ index, value -> sides.indexOf(max) != index }.sum()

            if(sum > max) return 1
            else return 2
        }
    }
}

fun main() = println(CompletionOfTriangle.solution(intArrayOf(1, 2, 3)))