package alg

fun findDuplicate(arr: Array<Int>): Int {
  val reduced = arr.reduce { a1, a2 ->
    a1 + a2
  }
  var sum = 0

  for (i in 1 until arr.size) {
    sum += i
  }
  return reduced - sum
}
