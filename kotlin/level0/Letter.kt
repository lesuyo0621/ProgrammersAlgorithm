class Letter {
    companion object {
        fun solution(message: String): Int = message.length * 2
    }
}

fun main() = println(Letter.solution("happy birthday!"))