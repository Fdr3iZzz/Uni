import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainTest {

    @Test
    fun graterConst() {
        assertEquals(graterConst(5, 6), true) // 1 drüber
        assertEquals(graterConst(5, 99999), true) // viel drüber
        assertEquals(graterConst(5, 5), false) // genau gleich
        assertEquals(graterConst(5, 4), false) // 1 drunter
        assertEquals(graterConst(5, -99999), false) // viel drunter
        assertEquals(graterConst(0, -1), false)
    }

    @Test
    fun square() {
        assertEquals(0, square(0))
        assertEquals(1, square(1))
        assertEquals(4, square(2))
        assertEquals(16, square(4))
        assertEquals(9801, square(99))
        assertEquals(1, square(-1))
        assertEquals(4, square(-2))
        assertEquals(16, square(-4))
        assertEquals(9801, square(-99))
    }

    @Test
    fun max() {
        assertEquals(2, max(  1, 2))
        assertEquals(2, max(2, 1))
        assertEquals(999, max(1, 999))
        assertEquals(999, max(999, 1))

        assertEquals(0, max(0, 0))
        assertEquals(1, max(0, 1))
        assertEquals(1, max(1, 0))

        assertEquals(-1, max(  -1, -2))
        assertEquals(-1, max(-2, -1))
        assertEquals(-1, max(-1, -999))
        assertEquals(-1, max(-999, -1))

    }

    @Test
    fun abs() {
        assertEquals(1, abs(1))
        assertEquals(9999, abs(9999))
        assertEquals(0, abs(0))
        assertEquals(1, abs(-1))
        assertEquals(9999, abs(-9999))
        assertEquals(0, abs(-0))
    }

    @Test
    fun modulo() {
        assertEquals(3, modulo(7, 4))
        assertEquals(0, modulo(12, 6))
        assertEquals(7, modulo(7, 10))
        assertEquals(0%17, moduloNeg(0, 17))
    }

    @Test
    fun moduloNeg() {
        assertEquals(-7%4, moduloNeg(-7, 4))
        assertEquals(-12%6, moduloNeg(-12, 6))
        assertEquals(-7%10, moduloNeg(-7, 10))

        assertEquals(4%-7, moduloNeg(4, -7))
        assertEquals(6%-12, moduloNeg(6, -12))
        assertEquals(10%-7, moduloNeg(10, -7))
    }

    @Test
    fun factorial() {
        assertEquals(1, factorial(1))
        assertEquals(2, factorial(2))
        assertEquals(6, factorial(3))
        assertEquals(24, factorial(4))
        assertEquals(2432902008176640000, factorial(20))
    }

    @Test
    fun intersection() {
        assertEquals("X: -3, Y: -12", intersection(5, 3, 7, 9))
        assertEquals("lines are equal", intersection(5, 3, 5, 3))
        assertEquals("lines are parallel", intersection(5, 3, 5, 7))
    }

    @Test
    fun intersectionWithPoints() {
        assertEquals("a1: 2, b1: 3, a2: -4, b2: 2", intersectionWithPoints(0, 3, 1, 5, 0, 2, 1, -2))
    }

    @Test
    fun sumDividable() {
        
    }

    @Test
    fun binaryToDecimal(){
        assertEquals(5, binaryToDecimal(101L))
        assertEquals(439, binaryToDecimal(110110111L))
        assertEquals(109, binaryToDecimal(1101101L))
        assertEquals(27, binaryToDecimal(11011L))
        assertEquals(122979, binaryToDecimal(11110000001100011L))
        assertEquals(12, binaryToDecimal(1100L))
        assertEquals(98, binaryToDecimal(1100010L))
    }

    @Test
    fun isPrime (){
        assertEquals(true, isPrime(7919))
        assertEquals(false, isPrime(6))
        assertEquals(true, isPrime(97))
        assertEquals(false, isPrime(100))
        assertEquals(true, isPrime(3))
        assertEquals(false, isPrime(0))
        assertEquals(false, isPrime(1))
        assertEquals(false, isPrime(-17))
    }

    @Test
    fun reverseString (){
        assertEquals("tseT", reverseString("Test"))
        assertEquals("!tseT", reverseString("Test!"))
        assertEquals("TseT", reverseString("TesT"))
        assertEquals("", reverseString(""))
        assertEquals("Dx tseT", reverseString("Test xD"))
    }

    @Test
    fun wordsInString() {
        assertEquals(2, wordsInString("Hello world"))
        assertEquals(2, wordsInString(" Hello world"))
        assertEquals(2, wordsInString("Hello world "))
        assertEquals(0, wordsInString(""))
        assertEquals(0, wordsInString("  "))
    }

    @Test
    fun checkParenthesis(){
        assertEquals(true, checkParenthesis("()"))
        assertEquals(true, checkParenthesis("(())()"))
        assertEquals(false, checkParenthesis("(()))()"))
        assertEquals(true, checkParenthesis("(foo)(bar())"))
        assertEquals(false, checkParenthesis(")"))
        assertEquals(true, checkParenthesis(" "))
        assertEquals(false, checkParenthesis(")("))
        assertEquals(true, checkParenthesis(""))
    }

    @Test
    fun caesarEncrypt() {
        assertEquals("Khoor!", caesarEncrypt("Hello!", 3))
        assertEquals("Lipps!", caesarEncrypt("Hello!", 4))
        assertEquals("Ebiil!", caesarEncrypt("Hello!", -3))
        assertEquals("Xyz", caesarEncrypt("Abc", -3))
        assertEquals("Olccb", caesarEncrypt("Lizzy", 3))
        assertEquals("Hello!", caesarEncrypt("Hello!", 0))
        assertEquals("z", caesarEncrypt("a", -53))
    }

    @Test
    fun power() {
        assertEquals(25, power(5,2))
    }

    @Test
    fun powerDigitizing() {
        assertEquals(91, powerDigitizing(139))
        assertEquals(0, powerDigitizing(0))
    }

    @Test
    fun factorialRecursive() {
        assertEquals(6, factorialRecursive(3))
        assertEquals(1, factorialRecursive(0))
    }

    @Test
    fun binaryToDecimalRecursive () {
        assertEquals(5, binaryToDecimalRecursive(101L))
        assertEquals(439, binaryToDecimalRecursive(110110111L))
        assertEquals(109, binaryToDecimalRecursive(1101101L))
        assertEquals(27, binaryToDecimalRecursive(11011L))
        assertEquals(122979, binaryToDecimalRecursive(11110000001100011L))
        assertEquals(12, binaryToDecimalRecursive(1100L))
        assertEquals(98, binaryToDecimalRecursive(1100010L))
    }

    @Test
    fun reverseStringRecursive () {
        assertEquals("tseT", reverseStringRecursive("Test"))
        assertEquals("!tseT", reverseStringRecursive("Test!"))
        assertEquals("TseT", reverseStringRecursive("TesT"))
        assertEquals("", reverseStringRecursive(""))
        assertEquals("Dx tseT", reverseStringRecursive("Test xD"))
    }

    @Test
    fun wordCount () {
        assertEquals(2, wordCount("Hello world"))
        assertEquals(2, wordCount(" Hello world"))
        assertEquals(2, wordCount("Hello world "))
        assertEquals(0, wordCount(""))
        assertEquals(0, wordCount("  "))
    }

    @Test
    fun isPalindrome () {
        assertEquals(true, isPalindrome("otto"))
        assertEquals(false, isPalindrome("ott"))
        assertEquals(false, isPalindrome("Otto"))
        assertEquals(true, isPalindrome("otxto"))
    }

    @Test
    fun fib () {
        assertEquals(0, fib(0))
        assertEquals(1, fib(1))
        assertEquals(1, fib(2))
        assertEquals(2, fib(3))
        assertEquals(3, fib(4))
        assertEquals(5, fib(5))
        assertEquals(8, fib(6))
        assertEquals(13, fib(7))
    }

    @Test
    fun isPrimeRecursive (){
        assertEquals(true, isPrimeRecursive(7919))
        assertEquals(false, isPrimeRecursive(6))
        assertEquals(true, isPrimeRecursive(97))
        assertEquals(false, isPrimeRecursive(100))
        assertEquals(true, isPrimeRecursive(3))
        assertEquals(false, isPrimeRecursive(0))
        assertEquals(false, isPrimeRecursive(1))
        assertEquals(false, isPrimeRecursive(-17))
    }

    @Test
    fun checkCorrectBrackets() {
        assertEquals(true, checkCorrectBrackets("()"))
        assertEquals(true, checkCorrectBrackets("(())()"))
        assertEquals(false, checkCorrectBrackets("(()))()"))
        assertEquals(true, checkCorrectBrackets("(foo)(bar())"))
        assertEquals(false, checkCorrectBrackets(")"))
        assertEquals(true, checkCorrectBrackets(" "))
        assertEquals(false, checkCorrectBrackets(")("))
        assertEquals(true, checkCorrectBrackets(""))
    }
}