class FirstNumber05 {
    /**
     * Binary search
     *
     * @param intArray array you want to search
     * @param searchedNumber number to find
     * @param left left most bound to search
     * @param right right most bound to search (don't change)
     * @return index of searchedNumber, else -1 (don't change)
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

        private fun multiply(frac: Fraction): Fraction {
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
        private fun reduce(frac: Fraction): Fraction {
            val gcd = euclideanAlgorithm(frac.nominator, frac.denominator)
            return Fraction(frac.nominator / gcd, frac.denominator / gcd)
        }
        /**
         * Euclidean algorithm
         *
         * @param a nominator
         * @param b denominator
         * @return gcd
         */
        private fun euclideanAlgorithm(a: Int, b: Int): Int {
            return if (b == 0) {
                a
            } else if (a == 0) {
                b
            } else if (a > b) {
                euclideanAlgorithm(a - b, b)
            } else {
                euclideanAlgorithm(a, b - a)
            }
        }
    }
}