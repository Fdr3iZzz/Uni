import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class _04Test {

    @Test
    fun createRandomIntArray() {
        assertEquals(6, createRandomIntArray(6).size)
    }

    @Test
    fun sumThrowsWithTwoDice(){
        assertEquals(intArrayOf(2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12), sumThrowsWithTwoDice(6))
    }
}