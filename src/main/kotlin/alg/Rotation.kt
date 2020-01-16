package alg

import java.time.LocalDateTime

fun rotateClockwise(matrix: Array<IntArray>): Array<IntArray> {

  val resultingMatrix = Array(matrix.size) {IntArray(matrix.size)}
  for (i in 0 until matrix.size) {
    for (j in 0 until matrix.size) {
      val curr = matrix[i][j];
      resultingMatrix[j][matrix.size - 1 - i] = curr;
    }
  }
  return resultingMatrix
}

fun main(args: Array<String>){
  val before = LocalDateTime.now().isBefore(LocalDateTime.of(2019, 7, 1, 0, 0, 0))
  println(before)
}
