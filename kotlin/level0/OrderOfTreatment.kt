class OrderOfTreatment {
    companion object {
        fun solution(emergency: IntArray): IntArray = emergency.map{ emergency.sortedDescending().indexOf(it) + 1 }.toIntArray()
    }
}

fun main() = println(OrderOfTreatment.solution(intArrayOf(3, 76, 24)).contentToString())