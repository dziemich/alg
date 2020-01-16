package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SmallerToTheRightTest {
  @Test
  fun verifiesCorrectlyArrays() {
    val inputArray: IntArray = intArrayOf(3, 4, 9, 6, 1)
    val verifierArray: IntArray = intArrayOf(1, 1, 2, 1, 0)
    val result = findSmallerToTheRight(inputArray);
    result.forEach { println(it) }
    Assertions.assertArrayEquals(verifierArray, result)
  }

  @Test
  fun verifiesCorrectly2() {
    val inputArray: IntArray = intArrayOf(9, 8, 7, 6, 2)
    val verifierArray: IntArray = intArrayOf(4, 3, 2, 1, 0)
    val result = findSmallerToTheRight(inputArray);
    result.forEach { println(it) }
    Assertions.assertArrayEquals(verifierArray, result)
  }

  @Test
  fun verifiesCorrectly3() {
    val inputArray: IntArray = intArrayOf(1, 2, 3, 4, 6)
    val verifierArray: IntArray = intArrayOf(0, 0, 0, 0, 0)
    val result = findSmallerToTheRight(inputArray);
    result.forEach { println(it) }
    Assertions.assertArrayEquals(verifierArray, result)
  }

  @Test
  fun verifiesCorrectlyEmpty() {
    val inputArray: IntArray = intArrayOf()
    val verifierArray: IntArray = intArrayOf()
    val result = findSmallerToTheRight(inputArray);
    result.forEach { println(it) }
    Assertions.assertArrayEquals(verifierArray, result)
  }

  @Test
  fun verifiesCorrectlyOneEl() {
    val inputArray: IntArray = intArrayOf(1)
    val verifierArray: IntArray = intArrayOf(0)
    val result = findSmallerToTheRight(inputArray);
    result.forEach { println(it) }
    Assertions.assertArrayEquals(verifierArray, result)
  }
}
