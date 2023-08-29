class DotProduct {
    companion object {
        fun solution(a: IntArray, b: IntArray): Int = a.foldIndexed(0) { index, acc, value -> acc + (a[index] * b[index]) }
    }
}

fun main() = println(DotProduct.solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))