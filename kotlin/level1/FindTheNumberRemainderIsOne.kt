class FindTheNumberRemainderIsOne {
    companion object {
        fun solution(n: Int): Int = (1..n).first{ n % it == 1 }
    }
}

fun main() = println(FindTheNumberRemainderIsOne.solution(10))