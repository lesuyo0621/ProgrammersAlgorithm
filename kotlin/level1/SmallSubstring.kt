class SmallSubstring {
    companion object {
        fun solution(t: String, p: String): Int = (0..t.length - p.length)
            .map { t.slice(it until it + p.length) }
            .count { p >= it }
    }
}

fun main() {
    println(SmallSubstring.solution("3141592", "271"))
}