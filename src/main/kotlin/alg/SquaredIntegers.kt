package alg

import kotlin.math.roundToInt

/*
Given a positive integer n, find the smallest number of squared integers which sum to n.

For example, given n = 13, return 2 since 13 = 3^2 + 2^2 = 9 + 4.

Given n = 27, return 3 since 27 = 3^2 + 3^2 + 3^2 = 9 + 9 + 9.
 */

fun findSmallestNumberOfSquaredIntegers(n: Int): Int {
  if (isSquare(n)) return 1
  val list: MutableList<Int> = mutableListOf()
  return decompose(n, 0, 100000)
}

fun decompose(n: Int, level: Int, lowestLevel: Int): Int {
  println("veryfying: " + n)
  var newLowestLevel = lowestLevel
  when (n) {
    3 -> newLowestLevel = findLowestLevel(level, lowestLevel, 3)
    2 -> newLowestLevel = findLowestLevel(level, lowestLevel, 2)
    1 -> newLowestLevel = findLowestLevel(level, lowestLevel, 1)
    0 -> newLowestLevel = findLowestLevel(level, lowestLevel, 0)
  }

  if (n <= 3) return newLowestLevel;

  for (i in Math.floor(Math.sqrt(n.toDouble())).roundToInt() downTo 2) {
    if (newLowestLevel > level ) { // stop counting if its impossible to achieve better result
      newLowestLevel =
        decompose(n - Math.pow(i.toDouble(), 2.0).toInt(), level + 1, newLowestLevel)
    }
  }
  return newLowestLevel
}

fun findLowestLevel(level: Int, lowestLevel: Int, addition: Int): Int{
  if (lowestLevel > level + addition){
    return level + addition
  }
  return lowestLevel
}

fun isSquare(n: Int): Boolean {
  val sqrtVal = Math.sqrt(n.toDouble())
  return sqrtVal - Math.floor(sqrtVal) == 0.0
}


fun main() {
  println(findSmallestNumberOfSquaredIntegers(15))
}
