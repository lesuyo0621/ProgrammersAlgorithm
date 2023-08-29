class QrCode {
    companion object {
        fun solution(q: Int, r: Int, code: String): String = code.indices
                                                                .filter { it % q == r }
                                                                .map{ code[it] }
                                                                .joinToString("")
    }
}

fun main() = println(QrCode.solution(3, 1, "qjnwezgrpirldywt"))