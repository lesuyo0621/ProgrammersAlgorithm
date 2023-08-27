class PrintTriangle {
    companion object {
        fun solution() {
            val n: Int = readLine()!!.toInt()

            for(i in 1..n){
                println("*".repeat(i))
            }
        }
    }
}

fun main() = PrintTriangle.solution()