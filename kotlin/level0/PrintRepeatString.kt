class PrintRepeatString {
    companion object {
        fun solution(my_string: String, n: Int): String = my_string.split("")
                                                                    .map{ it.repeat(n) }
                                                                    .joinToString("")
    }
}

fun main() = println(PrintRepeatString.solution("hello", 3))