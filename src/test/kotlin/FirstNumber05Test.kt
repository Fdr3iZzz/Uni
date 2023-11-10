import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FirstNumber05Test {
    private val num05 = FirstNumber05()
    @Test
    fun binarySearch() {
        assertEquals(1, num05.binarySearch(intArrayOf(0, 1, 1, 3), 1))
        assertEquals(-1, num05.binarySearch(intArrayOf(0, 1, 1, 3), 2))
        assertEquals(3, num05.binarySearch(intArrayOf(0, 1, 1, 3), 3))
    }

    @Test
    fun binarySearchNonRecursive() {
        assertEquals(1, num05.binarySearchNonRecursive(intArrayOf(0, 1, 1, 3), 1))
        assertEquals(-1, num05.binarySearchNonRecursive(intArrayOf(0, 1, 1, 3), 2))
        assertEquals(3, num05.binarySearchNonRecursive(intArrayOf(0, 1, 1, 3), 3))
    }

    @Test
    fun reduce() {
        assertEquals(FirstNumber05.Fraction(1,2), num05.reduce(FirstNumber05.Fraction(2, 4)))
    }

}