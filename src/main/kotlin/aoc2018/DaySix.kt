package aoc2018

// part one
data class Pos(var distance: Int, var closest: Int)

fun findRect() {
  val file = FileHelper.readLines("day6.txt")
    .map {
      val split = it.split(",")
      Integer.parseInt(split[0].trim()) to Integer.parseInt(split[1].trim())
    }

  val dimVert = file.map { it.first }
  val dimsDiffV = dimVert.min()!! to dimVert.max()!!

  val dimHorizon = file.map { it.second }
  val dimsDiffH = dimHorizon.min()!! to dimHorizon.max()!!

  val height = dimsDiffV.second - dimsDiffV.first + 1
  val width = dimsDiffH.second - dimsDiffH.first + 1

  val arr = Array(height) {
    Array(width) {
      Pos(20000, 20000)
    }
  }

// populate the array
  for (i in 0 until height) {
    for (j in 0 until width) {
      file.map {
        it.first - dimsDiffH.first to it.second - dimsDiffV.first
      }
        .forEachIndexed { index, point ->
          val d = calcManhattanDist(point, i to j)
          val currPos = arr[i][j]
          if (currPos.distance > d) {
            currPos.distance = d
            currPos.closest = index
          } else if (currPos.distance == d) {
            currPos.distance = d
            currPos.closest = -1
          }
        }
    }
  }
// cut edges


  val fc = mutableListOf<Pos>()
  val lc = mutableListOf<Pos>()

  arr.forEach {
    fc.add(it.first())
    lc.add(it.last())
  }

  val firstRow = arr.first().filter { it.closest != 1 }.groupBy { it.closest }.map { it.key }
  val lastRow = arr.last().filter { it.closest != 1 }.groupBy { it.closest }.map { it.key }
  val firstCol = fc.filter { it.closest != 1 }.groupBy { it.closest }.map { it.key }
  val lastCol = lc.filter { it.closest != 1 }.groupBy { it.closest }.map { it.key }

  val edges = arrayOf(
    *firstRow.toTypedArray(),
    *lastRow.toTypedArray(),
    *firstCol.toTypedArray(),
    *lastCol.toTypedArray()
  )

  val map = HashMap<Int, Int>()

  arr.forEach { row ->
    row.forEach { pos ->
      map.putIfAbsent(pos.closest, 0)
      map.computeIfPresent(pos.closest) { _, v -> v.plus(1) }
    }
  }

  val maxBy = map.filter { !edges.contains(it.key) }.maxBy { it.value }


  arr.forEach { col ->
    col.forEach {
      print(if (it.closest == -1) "." else it.closest)
    }
    println('x')
  }

  println("largest square: ${maxBy!!.value}")

}

fun calcManhattanDist(point1: Pair<Int, Int>, point2: Pair<Int, Int>): Int {
  return Math.abs(point1.first - point2.first) + Math.abs(point1.second - point2.second)
}


// part two
fun findSafeRegion(breakpoint: Int) {
  val file = FileHelper.readLines("day6.txt")
    .map {
      val split = it.split(",")
      Integer.parseInt(split[0].trim()) to Integer.parseInt(split[1].trim())
    }

  val dimVert = file.map { it.first }
  val dimsDiffV = dimVert.min()!! to dimVert.max()!!

  val dimHorizon = file.map { it.second }
  val dimsDiffH = dimHorizon.min()!! to dimHorizon.max()!!

  val height = dimsDiffV.second - dimsDiffV.first + 1
  val width = dimsDiffH.second - dimsDiffH.first + 1

  val arr = Array(height) {
    LongArray(width)
  }

//  val arr2 = Array(26) { IntArray(26) }


  val normalizedFile = file.map {
    it.first - dimsDiffH.first to it.second - dimsDiffV.first
  }

// populate the array
  for (i in 0 until height) {
    for (j in 0 until width) {
      var distanceCounter = 0L
      for (p in normalizedFile) {
        distanceCounter += calcManhattanDist(p, i to j).toLong()
      }
      arr[i][j] = distanceCounter
    }
  }

  val filtered = mutableListOf<Long>()

  arr.forEach { col ->
    col.forEach {
      if (it < breakpoint) {
        filtered.add(it)
      }
    }
  }
  println(filtered.size)

//  print("x")
}

fun main() {
//  findRect()
  findSafeRegion(10000)
}

