import kotlin.random.Random
class FirstNumber04 {

    fun createRandomIntArray(size: Int): IntArray {
        val randomInts = IntArray(size)
        for (i in randomInts.indices) {
            randomInts[i] = Random.nextInt()
        }
        return randomInts
    }

    fun sumThrowsWithTwoDice(numberOfSides: Int): IntArray {
        val possibleCombinations = numberOfSides * numberOfSides
        val array = intArrayOf(possibleCombinations)
        var count: Int = 0
        for (i in array.indices) {
            for (j in array.indices) {
                array[count] = i + j
                count++
            }
        }
        return array
    }

    fun swap(a: IntArray, index1: Int, index2: Int): IntArray {
        val tempInt = a[index1]
        a[index1] = a[index2]
        a[index2] = tempInt
        return a
    }

    fun shuffle(a: IntArray, numberOfSwaps: Int): Unit {
        for (i in 1..numberOfSwaps) {
            swap(a, Random.nextInt(0, a.size - 1), Random.nextInt(0, a.size - 1))
        }
    }

    fun arrayAverage(a: IntArray): Double {
        if (a.isEmpty()) return 0.0
        return a.sum().toDouble() / a.size
    }

    fun arrayMedian(a: IntArray): Int {
        a.sort()
        return a[a.size / 2]
    }

    fun std(a: IntArray): Double {
        TODO()
    }

    fun isSorted(a: IntArray): Boolean {
        if (a[0] >= a[1]) {
            for (i in a.indices - 1) {
                if (a[i] <= a[i + 1]) return false
            }
        } else {
            for (i in a.indices - 1) {
                if (a[i] >= a[i + 1]) return false
            }
        }
        return true
    }

    fun sortTwoRandomIndices(a: IntArray): IntArray {
        val ran1 = Random.nextInt(0, a.size)
        val ran2 = Random.nextInt(0, a.size)
        if (ran1 < ran2) {
            return if (a[ran1] > a[ran2]) return swap(a, ran1, ran2)
            else a
        } else {
            return if (a[ran1] < a[ran2]) swap(a, ran1, ran2)
            else a
        }
    }

    fun randomSwapSort(a: IntArray): IntArray {
        var intArray = a
        while (!isSorted(a)) {
            intArray = sortTwoRandomIndices(a)
        }
        return intArray
    }
}

data class Address(val streetName : String, val streetNumber : Int,
                    val postalNumber : Int, val cityName : String)

fun main () {
    val address = Address("Freundalle", 15, 30173, "Hannover")
    println("${address.streetName}, ${address.streetNumber}, ${address.postalNumber}, ${address.cityName}")
}