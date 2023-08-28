class AgeOfExoplanets {
    companion object {
        fun solution(age: Int): String = age.toString().map{ (it.code + 49).toChar() }.joinToString("")
    }
}

fun main() = println(AgeOfExoplanets.solution(23))