class SumOfPlusMinus {
    companion object {
        fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.indices.map{ if(signs[it]) absolutes[it] else -absolutes[it] }.sum()
    }
}

fun main() = println(SumOfPlusMinus.solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))