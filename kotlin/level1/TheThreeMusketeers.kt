class TheThreeMusketeers {
    companion object {
        var answer = 0;

        fun find(number: IntArray, start: Int, sum: Int, count: Int): Unit {
            for (i: Int in start until number.size){
                if(count == 3){
                    if (sum + number[i] == 0) answer++
                    continue
                }

                find(number, i + 1, sum + number[i], count + 1)
            }
        }

        fun solution(number: IntArray): Int = let { find(number, 0, 0, 1).let { answer } }
    }
}

fun main() = println(TheThreeMusketeers.solution(intArrayOf(-2, 3, 0, 2, -5)))