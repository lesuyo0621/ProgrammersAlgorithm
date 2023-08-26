class IceAmericano {
    companion object {
        fun solution(money: Int): IntArray = intArrayOf(money / 5500, money % 5500)
    }
}

fun main() = println(IceAmericano.solution(5500))