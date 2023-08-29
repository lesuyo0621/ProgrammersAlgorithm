class NumberOfFactorsAndAddition {
    companion object {
        fun solution(left: Int, right: Int): Int = (left..right)
            .map { num -> if((1..num).filter { num % it == 0 }.count() % 2 == 0) num else -num }
            .sum()
    }
}

fun main() = println(NumberOfFactorsAndAddition.solution(13, 17))