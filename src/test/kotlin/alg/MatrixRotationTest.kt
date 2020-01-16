package alg

import alg.rotateClockwise
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MatrixRotationTest {

  @Test
  fun assertsCorrectly3x3Matrix() {
    val inputArr: Array<IntArray> = arrayOf(
      intArrayOf(1, 2, 3),
      intArrayOf(4, 5, 6),
      intArrayOf(7, 8, 9)
    )
    val expectedArr: Array<IntArray> = arrayOf(
      intArrayOf(7, 4, 1),
      intArrayOf(8, 5, 2),
      intArrayOf(9, 6, 3)
    )
    Assertions.assertArrayEquals(rotateClockwise(inputArr), expectedArr);
  }

  @Test
  fun assertsCorrectly4x4Matrix() {
    val inputArr: Array<IntArray> = arrayOf(
      intArrayOf(1, 1, 1, 1),
      intArrayOf(2, 2, 2, 2),
      intArrayOf(3, 3, 3, 3),
      intArrayOf(4, 4, 4, 4)
    )
    val expectedArr: Array<IntArray> = arrayOf(
      intArrayOf(4, 3, 2, 1),
      intArrayOf(4, 3, 2, 1),
      intArrayOf(4, 3, 2, 1),
      intArrayOf(4, 3, 2, 1)
    )
    Assertions.assertArrayEquals(rotateClockwise(inputArr), expectedArr);
  }

  @Test
  fun assertsCorrectly5x5Matrix() {
    val inputArr: Array<IntArray> = arrayOf(
      intArrayOf(1, 1, 1, 1, 1),
      intArrayOf(2, 2, 2, 2, 2),
      intArrayOf(3, 3, 3, 3, 3),
      intArrayOf(4, 4, 4, 4, 4),
      intArrayOf(5, 5, 5, 5, 5)
    )
    val expectedArr: Array<IntArray> = arrayOf(
      intArrayOf(5, 4, 3, 2, 1),
      intArrayOf(5, 4, 3, 2, 1),
      intArrayOf(5, 4, 3, 2, 1),
      intArrayOf(5, 4, 3, 2, 1),
      intArrayOf(5, 4, 3, 2, 1)
    )
    Assertions.assertArrayEquals(rotateClockwise(inputArr), expectedArr);
  }
}
