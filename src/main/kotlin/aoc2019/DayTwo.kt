package aoc2019

object DayTwo {
  fun solveFirstPart(): Int {
    val arr = FileHelper.readLines("aoc2019/day2.txt")
      .flatMap { it.split(",") }
      .map { Integer.parseInt(it) }
      .toMutableList()

    var it = 0

    arr[1] = 12
    arr[2] = 2

    while (arr[it] != 99) {
      var result = 0;
      if (arr[it] == 1) {
        result = arr[arr[it + 1]] + arr[arr[it + 2]]
        arr[arr[it + 3]] = result
      } else if (arr[it] == 2) {
        result = arr[arr[it + 1]] * arr[arr[it + 2]]
        arr[arr[it + 3]] = result
      }
      it += 4
    }
    return arr[0]
  }

  fun solveSecondPart(): Int {
    val arr = FileHelper.readLines("aoc2019/day2.txt")
      .flatMap { it.split(",") }
      .map { Integer.parseInt(it) }
      .toMutableList()

    var it = 0

    arr[1] = 12
    arr[2] = 2

    while (arr[it] != 99) {
      var result = 0;
      if (arr[it] == 1) {
        result = arr[arr[it + 1]] + arr[arr[it + 2]]
        arr[arr[it + 3]] = result
      } else if (arr[it] == 2) {
        result = arr[arr[it + 1]] * arr[arr[it + 2]]
        arr[arr[it + 3]] = result
      }
      println(result)
      if (result == 19690720 && arr[it + 3] == 0) {
        return arr[1] * 100 + arr[2]
      }
      it += 4
    }
    return arr[1] * 100 + arr[2]
  }

}

fun main(args: Array<String>) {
//  println(DayTwo.solveFirstPart())
  println(DayTwo.solveSecondPart())
}
