class TernaryReversal {
    companion object {
        fun solution(n: Int): Int = n.toString(3).reversed().toInt(3)
    }
}

fun main() = println(TernaryReversal.solution(45))