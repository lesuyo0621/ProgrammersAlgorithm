class ClosestSameLetter {
    companion object {
        fun solution(s: String): IntArray {
            val map: MutableMap<Char, Int> = mutableMapOf()

            return (0 until s.length).map {
                var num: Int = -1

                if(map.containsKey(s[it])) num = it - map[s[it]]!!
                map[s[it]] = it

                num
            }.toIntArray()
        }
    }
}

fun main() = println(ClosestSameLetter.solution("banana").contentToString())