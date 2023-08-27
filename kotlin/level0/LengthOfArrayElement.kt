class LengthOfArrayElement {
    companion object {
        fun solution(strList: Array<String>): IntArray = strList.map{ it.length }.toIntArray()
    }
}

fun main() = println(LengthOfArrayElement.solution(arrayOf("We", "are", "the", "world!")).contentToString())