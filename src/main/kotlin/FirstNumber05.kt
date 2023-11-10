import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt

class FirstNumber05 {
    /**
     * Binary search
     *
     * @param intArray array you want to search
     * @param searchedNumber number to find
     * @param left left most bound to search (don't change)
     * @param right right most bound to search (don't change)
     * @return index of searchedNumber, else -1
     */
    tailrec fun binarySearch (intArray : IntArray, searchedNumber : Int, left : Int = 0, right : Int = intArray.size-1) : Int{
        // handle not existing
        if (left > right) {
            return -1
        }
        val index = (left+right)/2
        if (intArray[index] == searchedNumber) { // check if found
            return index
        }
        return if (intArray[index] > searchedNumber) { // check lower half
            binarySearch(intArray, searchedNumber, left, index-1)
        } else { // check upper half
            binarySearch(intArray, searchedNumber, index+1, right)
        }
    }
    /**
     * Binary search non-recursive
     *
     * @param intArray array you want to search
     * @param searchedNumber number to find
     * @return index of searchedNumber, else -1
     */
    fun binarySearchNonRecursive(intArray: IntArray, searchedNumber: Int) : Int{
        var left = 0
        var right = intArray.size-1
        var index : Int = (left+right)/2
        while (true) {
            if (intArray[index] == searchedNumber) {
                while (true){
                    if (index>=0 && intArray[index-1] == searchedNumber) {
                        index--
                    } else return index
                }
            } else if (intArray[index] >= searchedNumber) {
                right = index-1
                index = (left+right)/2
            } else if (index == right) {
                return -1
            } else {
                left = index+1
                index = (left+right)/2
            }
        }
    }
    data class Fraction(val nominator: Int, val denominator: Int) {
        init {
            if (this.denominator == 0) throw ArithmeticException("Div by 0")
        }
        fun multiply(frac: Fraction): Fraction {
            return this.reduce(Fraction(nominator * frac.nominator, denominator * frac.denominator))
        }

        fun divide(frac: Fraction): Fraction {
            val flippedFrac: Fraction = Fraction(frac.denominator, frac.nominator)
            return reduce(frac.multiply(flippedFrac))
        }

        fun add (frac : Fraction) : Fraction{
            val commonDenominator = this.denominator * frac.denominator
            val newNumerator = this.nominator * frac.denominator + frac.nominator * this.denominator
            return reduce(Fraction(newNumerator, commonDenominator))
        }

        fun subtract (frac : Fraction) : Fraction{
            val commonDenominator = this.denominator * frac.denominator
            val newNumerator = this.nominator * frac.denominator - frac.nominator * this.denominator
            return reduce(Fraction(newNumerator, commonDenominator))
        }
        /**
         * Reduce
         *
         * @param frac fraction to gcd
         * @return gcd of a fraction
         */
        fun reduce(frac: Fraction): Fraction {
            val gcd = euclideanAlgorithm(this.nominator, this.denominator)
            return Fraction(this.nominator / gcd, this.denominator / gcd)
        }
        /**
         * Euclidean algorithm
         *
         * @param a nominator
         * @param b denominator
         * @return gcd
         */
        fun euclideanAlgorithm(a: Int, b: Int): Int {
            return if (b == 0) a else euclideanAlgorithm(b, a % b)
        }
    }

    /**
     * Point in coordinate system
     *
     * @property x
     * @property y
     * @constructor Create a Point
     */
    data class Point (val x : Double, val y : Double) {
        fun distance(p : Point) : Double {
            // use Pythagoras (x2-x1)^2 + (y2-y1)^2 = c^2
            return sqrt((p.x - this.x).pow(2) + (p.y - this.y).pow(2))
        }
    }

    /**
     * Triangle
     *
     * @property a first Point
     * @property b second Point
     * @property c third Point
     * @constructor Create a Triangle out of 3 Points
     */
    data class Triangle (val a : Point, val b : Point, val c : Point) {
        /**
         * Perimeter
         *
         * @return perimeter as Double
         */
        fun perimeter() : Double{
            val triple = lengthOfSides()
            val result = triple.first+triple.second+triple.third
            return result.toDouble()
        }

        /**
         * Length of sides
         * 1. - 2.; 2. - 3.; 3 - 1. Point
         *
         * @return Triple with length of each side as Double
         */
        fun lengthOfSides() : Triple<Double, Double, Double> {
            return Triple(a.distance(b), b.distance(c), c.distance(a))
        }

        /**
         * Area via Heron's formula
         *
         * @return area of triangle as Double
         */
        fun area() : Double{
            val perimeter = perimeter()
            val lengthOfSides = lengthOfSides()
            val result =
                sqrt(
                    perimeter
                * (perimeter-lengthOfSides.first)
                * (perimeter-lengthOfSides.second)
                * (perimeter-lengthOfSides.third))
            return result.toDouble()
        }
    }
}