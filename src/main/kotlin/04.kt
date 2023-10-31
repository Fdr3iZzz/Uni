import kotlin.math.pow
import kotlin.random.Random

fun createRandomIntArray(size : Int) : IntArray {
    val randomInts = IntArray(size)
    for (i in randomInts.indices) {
        randomInts[i]= Random.nextInt()
    }
    return randomInts
}

fun sumThrowsWithTwoDice(numberOfSides : Int) : IntArray {
    val maxSize = (numberOfSides-1)*4
    val sumTwoDice = IntArray(maxSize)

    return sumTwoDice
}