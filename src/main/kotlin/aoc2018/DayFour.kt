package aoc2018

fun sort() {
  val container = mutableListOf<Shift>()
  var curr = Shift(emptyList<String>().toMutableList())
  val regex = "#[0-9]{1,5}".toRegex()
  val sorted = FileHelper.readLines("day4.txt")
    .sorted()
    .forEach {
      val match = regex.find(it)
      if (match != null) {
        if (!curr.logs.isEmpty()) {
          container.add(curr)
        }
        curr = Shift(mutableListOf())
      }
      curr.logs.add(it)
    }
  container.add(curr)

  val groupBy = container.map {
    val id = regex.find(it.logs[0])!!.value

    val indicesSleeping = mutableListOf<Pair<Int, Int>>()

    for (i in 1 until it.logs.size step 2) {
      val fallAsleepHour = it.logs[i].substring(1, 17)
      val wakeUpHour = it.logs[i + 1].substring(1, 17)

      if (fallAsleepHour.substring(1, 14) == wakeUpHour.substring(1, 14)) {
        indicesSleeping.add(
          Integer.parseInt(fallAsleepHour.substring(14)) to Integer.parseInt(
            wakeUpHour.substring(14)
          )
        )
      }
    }
    id to indicesSleeping
  }
    .groupBy { it.first }
    .mapValues { it.value.flatMap { iter -> iter.second } }

  val maxed = groupBy
    .mapValues { it.value.map { iter -> iter.second - iter.first }.sum() }
    .maxBy { it.value }


  val min = getMin(groupBy[maxed!!.key] ?: error("missing"))

  println(min)
  val guardId = Integer.parseInt(maxed.key.substring(1))
  println(guardId)
  println(min*guardId)

  val maxBy: Map.Entry<String, Pair<Int, Int>>? = groupBy.mapValues { getMin2(it.value) }.maxBy { it.value.first }

  println("strat 2")

  val id = Integer.parseInt(maxBy!!.key.substring(1))
  val minuter = maxBy!!.value.second
  println(id)
  println(minuter)
  println(id * minuter)

}

fun getMin(timings: List<Pair<Int, Int>>): Int {
  val arr = IntArray(60)

  timings.forEach {
    for (i in it.first until it.second){
      arr[i]++
    }
  }
  return arr.indexOf(arr.max()!!)
}

fun getMin2(timings: List<Pair<Int, Int>>): Pair<Int, Int> {
  val arr = IntArray(60)

  timings.forEach {
    for (i in it.first until it.second){
      arr[i]++
    }
  }
  val max = arr.max()!!
  return max to arr.indexOf(max)
}


fun main() {
  sort()
}

data class Shift(val logs: MutableList<String>)
