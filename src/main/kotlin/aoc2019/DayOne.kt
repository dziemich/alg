package aoc2019

object DayOne{
fun solveFirstPart(): Double {
  val result = FileHelper.readLines("aoc2019/day1.txt")
    .map { Integer.parseInt(it).toDouble() }
    .map { Math.floor(it.div(3.0)) - 2 }
    .sum()
  return result
}

fun solveSecondPart(): Double {
  val result = FileHelper.readLines("aoc2019/day1.txt")
    .map { Integer.parseInt(it).toDouble() }
    .map { calcFuel(it) }
    .sum()
  return result
}

fun calcFuel(m: Double): Double {
  var m1 = m
  var total = 0.0
  while (m1 > 0){
    val res = Math.floor(m1.div(3.0)) - 2
    m1 = if (res >= 0) res else 0.0
    total += m1
  }
  return total
}

}
fun main() {
  println(DayOne.solveFirstPart())
  println(DayOne.solveSecondPart())
}
