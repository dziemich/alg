package alg

import alg.balancedSums
import alg.pairs
import alg.twoSum
import alg.twoSum2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LeetCodeTwoSumITest {

  @Test
  fun testCorrectness(): Unit {
    val arr = intArrayOf(2, 7, 11, 15)
    val target = 9
    Assertions.assertArrayEquals(intArrayOf(0, 1), twoSum(arr, target))
  }
  @Test
  fun testCorrectnessofTwoSum2(): Unit {
    val arr = intArrayOf(2, 7, 11, 15)
    val target = 9
    Assertions.assertArrayEquals(intArrayOf(1, 2), twoSum2(arr, target))
  }
  @Test
  fun testCorrectnessofPairs(): Unit {
    val arr = arrayOf(1, 3, 5, 8, 6, 4, 2)
    val target = 2
    Assertions.assertEquals(5, pairs(target, arr))
  }
  @Test
  fun testCorrectnessofPairs2(): Unit {
    val arr = arrayOf(1, 5, 3, 4, 2)
    val target = 2
    Assertions.assertEquals(3, pairs(target, arr))
  }
  @Test
  fun testCorrectnessofBalancedSums(): Unit {
    val arr = arrayOf(5, 6, 8, 11)
    Assertions.assertEquals("YES", balancedSums(arr))
  }

  @Test
  fun testCorrectnessofBalancedSums2(): Unit {
    val arr = arrayOf(0, 2, 0, 0, 0)
    Assertions.assertEquals("YES", balancedSums(arr))
  }
  @Test
  fun testCorrectnessofBalancedSums3(): Unit {
    val arr = arrayOf(1, 2, 3)
    Assertions.assertEquals("NO", balancedSums(arr))
  }

  @Test
  fun testCorrectnessofBalancedSums4(): Unit {
    val arr = arrayOf(1, 2, 3, 3)
    Assertions.assertEquals("YES", balancedSums(arr))
  }

  @Test
  fun testCorrectnessofBalancedSums5(): Unit {
    val arr = arrayOf(0, 0, 2, 0)
    Assertions.assertEquals("YES", balancedSums(arr))
  }
}
