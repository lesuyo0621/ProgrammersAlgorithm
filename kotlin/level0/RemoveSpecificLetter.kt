class RemoveSpecificLetter {
    companion object {
        fun solution(my_string: String, letter: String): String = my_string.filter{ it.toString() != letter }
    }
}

fun main() = println(RemoveSpecificLetter.solution("abcdef", "f"))