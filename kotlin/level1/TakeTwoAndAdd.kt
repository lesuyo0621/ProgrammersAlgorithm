class TakeTwoAndAdd {
    companion object {
        fun solution(numbers: IntArray): IntArray {
            val set: MutableSet<Int> = mutableSetOf()

            numbers.indices.forEach {
                (it + 1..numbers.lastIndex).forEach { it2: Int ->
                    set.add(numbers[it] + numbers[it2])
                }
            }

            return set.toIntArray().sortedArray()
        }
    }
}

fun main() = println(TakeTwoAndAdd.solution(intArrayOf(2, 1, 3, 4, 1)).contentToString())