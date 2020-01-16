package alg

import alg.findUniquePrefixes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UniquePrefixesTest {

  @Test
  fun verfiesCorrectlyPrefixes(){
    val inputArr = arrayOf("dog", "cat", "apple", "apricot", "fish")
    val outputArr = arrayOf("d", "c", "app", "apr", "f")
    Assertions.assertArrayEquals(outputArr, findUniquePrefixes(inputArr))
  }

  @Test
  fun verfiesCorrectlyPrefixes2(){
    val inputArr = arrayOf("aaaab", "aaab", "aca", "acca", "az")
    val outputArr = arrayOf("aaaa", "aaab", "aca", "acc", "az")
    Assertions.assertArrayEquals(outputArr, findUniquePrefixes(inputArr))
  }
}
