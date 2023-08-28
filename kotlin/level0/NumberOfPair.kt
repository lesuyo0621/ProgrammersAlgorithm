class NumberOfPair {
    companion object {
        fun solution(n: Int): Int = (1..n).filter{ n % it == 0 }.count()
    }
}

fun main() = println(NumberOfPair.solution(20))