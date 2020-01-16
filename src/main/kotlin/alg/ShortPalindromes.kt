package alg

import java.math.BigInteger
import kotlin.math.pow

const val REM: Long = 1000000007

fun factorial(n: Long) = when {
  n < 0 -> throw IllegalArgumentException("negative numbers not allowed")
  else -> {
    var ans = 1L
    for (i in 2..n) ans *= i
    ans
  }
}

fun binomial(n: Long, k: Long) = when {
  n < 0 || k < 0 -> throw IllegalArgumentException("negative numbers not allowed")
  n == k -> 1L
  else -> {
    var ans = 1L
    for (i in n - k + 1..n) ans *= i
    ans / factorial(k)
  }
}

fun shortPalindrome2(s: String): Int {
  var counter: Int = 0

  for (i in s.indices) {
    val eligibleFromTheRight = determineEligibleFromTheRight(i, s)
    if (!eligibleFromTheRight.isEmpty()) {
      counter += eligibleFromTheRight.fold(BigInteger.ZERO) { acc: BigInteger, ind: Long ->
        acc + BigInteger.valueOf(
          findInnerPalindromeOptions(i, ind, s)
        )
      }.rem(
        BigInteger.valueOf(10.toDouble().pow(9).plus(7).toLong())
      ).toInt()

    }
  }
  return counter
}

fun findInnerPalindromeOptions(left: Int, right: Long, s: String): Long {
  return s.substring(left + 1, right.toInt())
    .groupBy { it }
    .map { it.value.size.toLong() }
    .filter { it >= 2 }
    .map { binomial(it, 2) }
    .sum()
}

fun determineEligibleFromTheRight(index: Int, s: String): List<Long> {
  val eligibleIndices = mutableListOf<Long>()
  val letter = s[index]
  for (i in s.length - 1 downTo index + 3) {
    if (s[i] != letter) continue
    eligibleIndices.add(i.toLong())
  }
  return eligibleIndices
}

//fun smartGroupBy(s: String){
//  s.groupByTo(mutableMapOf()){
//
//  }
//}


private fun createOccurences(s: String): List<Pair<Char, Int>> {
  val collector = mutableListOf<MutableList<Char>>()
  var curr = mutableListOf<Char>()
  curr.add(s[0])
  for (i in 1 until s.length) {
    val c = s[i]
    if (c == s[i - 1]) {
      curr.add(c)
    } else {
      collector.add(curr.toMutableList())
      curr = mutableListOf()
      curr.add(c)
    }
  }
  collector.add(curr)
  return collector.map { it[0] to it.size }
}

fun shortPalindrome(s: String): Int {
  var cnt = 0L

  val occs = createOccurences(s)
  for (i in 0 until occs.size) {
    val leftMost = occs[i]
    if (leftMost.second >= 4) {
      cnt += binomial(leftMost.second.toLong(), 4).rem(REM)
    }

    for (j in occs.size - 1 downTo i + 1) {
      val rightMost = occs[j]
      if (rightMost.first == leftMost.first) {
        occs.subList(i + 1, j)
          .groupBy({ it.first }, { it.second })
          .mapValues { it.value.fold(0) { acc, i -> acc + i }.toLong() }
          .forEach {
            val addition = leftMost.second * rightMost.second * binomial(it.value, 2)
            cnt += addition.rem(REM)
          }
        val betweenItself = getBetweenItself(leftMost.second, rightMost.second);
        cnt += betweenItself.rem(REM)
      }
    }
    cnt = if (cnt >= REM) cnt.rem(REM) else cnt
  }
  return cnt.toInt()
}

fun getBetweenItself(leftMost: Int, rightMost: Int): Long {

  var addition = 0L

  if (leftMost >= 3) {
    addition += binomial(leftMost.toLong(), 3) * rightMost
  }

  if (rightMost >= 3) {
    addition += binomial(rightMost.toLong(), 3) * leftMost
  }

  if (rightMost >= 2 && leftMost >= 2) {
    addition += binomial(leftMost.toLong(), 2) * binomial(rightMost.toLong(), 2)
  }

  return addition
}


internal var mod = 1000 * 1000 * 1000 + 7

fun x(s: String) {
  val arr1 = IntArray(26)
  val arr2 = Array(26) { IntArray(26) }
  val arr3 = IntArray(26)
  var ans = 0
  for (i in 0 until s.length) {
    val index = (s.get(i) - 'a').toInt()
    ans += arr3[index] % mod
    ans = ans % mod
    for (j in 0..25) {
      arr3[j] += arr2[j][index] % mod
      arr3[j] = arr3[j] % mod
    }
    for (j in 0..25) {
      arr2[j][index] += arr1[j] % mod
      arr2[j][index] = arr2[j][index] % mod
    }

    arr1[index]++
    arr1[index] = arr1[index] % mod
  }
  println(ans)
}


fun shortPalindrome3(s: String) {

  val letters = HashMap<Char, Int>()
  var cnt = 0;

  for (i in 0 until s.length) {
    val c = s[i]
    letters.computeIfAbsent(c) { 0 }
    letters.computeIfPresent(c) { _, u -> u + 1 }

  }
  print("xx")
}

fun main() {
  shortPalindrome3("xaxxx")
}
