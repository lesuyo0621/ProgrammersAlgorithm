class CalculateTheShortfall {
    companion object {
        fun solution(price: Int, money: Int, count: Int): Long = (1..count).map { (it * price).toLong() }.sum().let{ if(it - money > 0) it - money else 0 }
    }
}

fun main() = println(CalculateTheShortfall.solution(3, 20,4))