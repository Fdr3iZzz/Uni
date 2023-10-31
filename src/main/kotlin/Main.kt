import kotlin.math.pow

fun main(args: Array<String>) {

}

fun graterConst(const: Int, input: Int): Boolean {
    return input > const
}

fun square(input: Int): Int {
    return input * input
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun abs(input: Int): Int {
    return if (input >= 0) {
        input
    } else {
        input * -1
    }
}

fun modulo(a: Int, b: Int): Int {
    return a - (a / b) * b
}

fun moduloNeg(a: Int, b: Int): Int {
    if (a < 0) {
        val absA = abs(a)
        return (absA - (absA / b) * b) * -1
        // return a-((a/b)*b)
    }
    return a - ((a / b) * b)
}

/**
 *  Für n 0 < n< 20
 */
fun factorial(n: Int): Long {
    var sum: Long = 1
    for (i in 1..n) {
        sum *= i
    }
    return sum
}

fun intersection(a1: Int, b1: Int, a2: Int, b2: Int): String {
    if (a1 == a2) {
        if (b1 == b2) {
            return "lines are equal"
        } else {
            return "lines are parallel"
        }
    } else {
        val x = (b1 - b2) / (a2 - a1)
        val y = a1 * x + b1
        return "X: $x, Y: $y"
    }
}

fun intersectionWithPoints(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): String {
    val a1 = (ay1 - ay2) / (ax1 - ax2)
    val b1 = -a1 * ax1 + ay1
    val a2 = (by1 - by2) / (bx1 - bx2)
    val b2 = -b1 * bx1 + by1
    return "a1: $a1, b1: $b1, a2: $a2, b2: $b2"
}

/**
 * Converts binary to decimal
 * @param positive binary as Long
 * @return decimal as tnt
 */
fun binaryToDecimal(input: Long): Int {
    val inputAsString = input.toString()
    var output: Int = 0
    var power: Int = inputAsString.length - 1

    for (i in inputAsString.indices) { // loop through all numbers
        if (inputAsString[i] == '1') { // check if something has to be done
            output += 2.0.pow(power.toDouble()).toInt() // calculate 2 to the power of power
        }
        power--
    }
    return output
}

/**
 * check if input is a prime
 * @param positive int
 * @return boolean
 */
fun isPrime(input: Int): Boolean {
    if (input <= 1) return false // handle neg and 1
    if (input <= 3) return true // handle 2 and 3
    if (input % 2 == 0 || input % 3 == 0) return false // check if dividable by 2 or 3
    return true // else its a prime
}

/**
 * reverses a String
 * @param any String
 * @return String in reverse
 */
fun reverseString(input: String): String {
    var output: String = ""
    for (i in input.length - 1 downTo 0) { // count from the highest index down to 0
        output += input[i].toString() // char to new String
    }
    return output
}

/**
 * return number of words in String
 * @param any String
 * @return result as int
 */
fun wordsInString(input: String): Int {
    val trimedInput: String = input.trim()
    if (trimedInput.isEmpty()) return 0
    var output = 1
    for (i in trimedInput.indices) { // iterate through every index
        if (i == trimedInput.length - 1) break
        if (trimedInput[i] == ' ' && trimedInput[i + 1] != ' ') { // check if char is space and after a letter (checks for non space cause lazy)
            output++ // add word count
        }
    }
    return output
}

/**
 * check if String has correctly placed brackets
 * @param any String
 * @return result as boolean
 */
fun checkParenthesis(input: String): Boolean {
    var count: Int = 0
    for (i in input) { // iterate through String
        if (i == '(') count++ // increase if open
        else if (i == ')') count-- //decrease if closed
        if (count < 0) return false // check if more closed then opened
    }
    return count == 0 // check if ( and ) are the same amount
}

/**
 * run caesars encryption (offset/ shift all characters in alphabet by provided value)
 * @param input String that gets encrypted
 * @param int by which to offset (can be negative)
 * @return encrypted String
 */
fun caesarEncrypt(s: String, offset: Int): String {
    var output: String = ""
    if (offset == 0) return s // when 0 nothing changes

    for (i in s) {
        if (i.isLowerCase()) { // handle lower case
            // get char as unicode; norm with "a" so it's now the position number in alphabet; add offset; use modulo to wrap (no out of bounce)
            // add numbers of letters to handle subtraction; correct offset'ed value to number of letters; add position number of "a" to get unicode
            output += (((i.code - 'a'.code + offset) % 26 + 26) % 26 + 'a'.code).toChar()
        } else if (i.isUpperCase()) { // handle upper case
            output += (((i.code - 'A'.code + offset) % 26 + 26) % 26 + 'A'.code).toChar()
        } else
            output += i // add unaltered char to String
    }
    return output
}

/**
 * calculate power of inputted values with tail recursion
 *@param n Int as base
 *@param exp Int as exponent
 * @return result as Int
 */
tailrec fun power(n: Int, exp: Int, result: Int = 1): Int {
    return if (exp == 0) {
        result
    } else {
        power(n, exp - 1, result * n)
    }
}

tailrec fun powerDigitizing(input: Int, result: Int = 0): Int {
    return if (input == 0) {
        result
    } else {
        val lastChar = input % 10
        powerDigitizing(input/10, result + lastChar*lastChar)
    }
}

tailrec fun factorialRecursive(n : Int, result: Int = 1) : Int {
    return if (n == 0) {
        result
    } else {
        factorialRecursive(n-1, result*n)
    }
}

tailrec fun binaryToDecimalRecursive (input : Long, baseWeight : Int = 1, result : Int = 0) : Int{
    return if (input == 0L) {
        result
    } else {
        val lastChar = input % 10
        binaryToDecimalRecursive(input / 10, baseWeight*2, (result + lastChar *baseWeight).toInt())
    }
}

tailrec fun reverseStringRecursive (input : String, result: String = "") : String{
    return if (input.isEmpty()){
        result
    } else {
        reverseStringRecursive(input.drop(1), input [0] + result)
    }
}

tailrec fun wordCount (input : String, result: Int = 0) : Int{
    if (input.isEmpty()) return 0
    return if (input.length == 2){
        if (input[0].isLetter()) result+1
        else result
    } else {
        if (input[0].isLetter() && input[1].isWhitespace()) wordCount(input.drop(2), result + 1)
        else wordCount(input.drop(1), result)

    }
}

tailrec fun isPalindrome(input : String) : Boolean{
    return if (input.isEmpty()) {
        true
    } else {
        if (input.first() == input.last()) isPalindrome(input.drop(1).dropLast(1))
        else return false
    }
}

tailrec fun fib(input: Int, a : Int = 1, b : Int = 0) : Int {
    return if (input == 0) {
        b
    } else {
        fib(input-1, b, a + b)
    }
}

tailrec fun isPrimeRecursive (input : Int, divisor : Int = input) : Boolean{
    if (input <= 1) return false // neg numbers, 0 and 1
    if (input <= 3) return true // 1 and 2
    if (input % 2 == 0) return false // filter even numbers

    if (divisor * divisor > input) return true // stop if nothing wrong till the smallest sqrt

    return if (input % divisor == 0) { // check dividable
        false
    } else {
            isPrimeRecursive(input, divisor+2)
        }
}

fun checkCorrectBrackets (input : String, index : Int = 0, count : Int = 0) : Boolean{
    if (index >= input.length) return count == 0
    if (')' == input[index]) {
        return if (count > 0) checkCorrectBrackets(input, index + 1, count - 1)
        else false
    }
    return if ('(' == input[index]) checkCorrectBrackets(input, index + 1, count + 1)
    else checkCorrectBrackets(input, index + 1, count)
}