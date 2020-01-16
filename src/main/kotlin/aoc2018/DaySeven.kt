package aoc2018

val regex = "( [A-Z] ){1}".toRegex()

// part one
fun findOrder() {
  val pairs = FileHelper.readLines("day7.txt")
    .map {
      val matches = regex.findAll(it).toList()
      matches[0].value.trim() to matches[1].value.trim()
    }


  val m = pairs.groupBy({ it.second }, { it.first }).toMutableMap()

  val missing =
    pairs.filter { !m.containsKey(it.first) }.groupBy({ it.first }, { "" })
      .toSortedMap()
  val starter = missing.firstKey()
  missing.remove(starter);
  m.putAll(missing)
  val map = m.toSortedMap()
  val seq = StringBuilder(starter)

  while (seq.length <= map.size) {
    for (el in map) {
      if (!seq.contains(el.key)) {
        if (el.value.all { seq.contains(it) }) {
          seq.append(el.key)
          break
        }
      }
    }
  }

  print(seq.toString())
}

data class Worker(var free: Boolean = true, var freeAt: Int = 0, var currentJob: String = "")

val OFFSET = 60
val WORKER_POOL_SIZE = 5

fun findSeconds() {
  val pairs = FileHelper.readLines("day7.txt")
    .map {
      val matches = regex.findAll(it).toList()
      matches[0].value.trim() to matches[1].value.trim()
    }

  val m = pairs.groupBy({ it.second }, { it.first }).toMutableMap()

  val missing = pairs.filter { !m.containsKey(it.first) }.groupBy({ it.first }, { "" })
  m.putAll(missing)


  val map = m.toSortedMap();
  var counter = 0
  val seq = StringBuilder()

  val workers = Array(WORKER_POOL_SIZE) { Worker() }
  val inProgress = mutableListOf<String>()

  while (seq.length < map.size) {
    if (counter != 0) {
      workers
        .filter { it.freeAt == counter }
        .forEach {
          seq.append(it.currentJob)
          it.free = true
          it.freeAt = 0
          inProgress.remove(it.currentJob)
        }
    }
    workers
      .filter { it.free }
      .forEach { worker ->
        for (stage in map) {
          if (!seq.contains(stage.key)) {
            if (stage.value.all { seq.contains(it) } && !inProgress.contains(stage.key)) {
              worker.free = false
              worker.currentJob = stage.key
              worker.freeAt = stage.key[0] - 'A' + counter + OFFSET + 1
              inProgress.add(stage.key)
              break
            }
          }
        }
      }
    println(seq)
    counter = workers.map { it.freeAt }.filter { it != 0 && it != counter }.min() ?: counter
  }
  print(counter)
}

fun main() {
  findOrder()
  findSeconds()
}
