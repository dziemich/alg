package alg


fun superDigit(n: String, k: Int): Int {

  val t = n.split("")
    .filter { !it.isEmpty() }
    .map {
      it.toLong()
    }
    .reduce { a, b -> a + b }
    .times(k)

  return supDigit(t).toInt()

}

fun supDigit(i: Long): Long {
  return if (i / 10 == 0L) {
    i
  } else {
    val sum = i.toString().split("")
      .filter { !it.isEmpty() }
      .map { it.toLong() }
      .reduce { a, b -> a + b }

    return supDigit(sum)
  }
}
