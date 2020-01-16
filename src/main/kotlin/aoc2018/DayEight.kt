package aoc2018

//data class Node(val entries: MutableList<Int>)

// part1
class Solution1 {

  var index: Int = 0

  fun sumNodes() {
    val input = FileHelper.readLines("day8.txt")
      .flatMap { it.split(" ") }
      .map { Integer.parseInt(it) }

    val list = build(string = input, list = mutableListOf<Int>())

    println(list.sum())
  }

  fun build(string: List<Int>, list: MutableList<Int>): MutableList<Int> {
    val childrenCount = string[index]
    val entriesCount = string[index + 1]
    index += 2
    for (i in 1..childrenCount) {
      build(string, list)
    }

    list.addAll(string.slice(index until index + entriesCount))
    index += entriesCount

    return list
  }
}

// part2
class Solution2 {

  var index: Int = 0

  fun getNodeValue() {
    val input = FileHelper.readLines("day8.txt")
      .flatMap { it.split(" ") }
      .map { Integer.parseInt(it) }

    val result = build(string = input)

    println(result)
  }

  fun build(
    string: List<Int>
  ): Int {
    val childrenCount = string[index]
    val entriesCount = string[index + 1]
    index += 2
    val children = mutableListOf<Int>()

    for (i in 1..childrenCount) {
      children.add(build(string))
    }

    val sums = mutableListOf<Int>()
    if (childrenCount == 0) {
      sums.addAll(string.slice(index until index + entriesCount))
    } else {
      for (i in index until index + entriesCount){
        val ind = string[i]
//        println("$ind:${children.size}")
        children.forEach { print(it) }
        println("-")
        if (ind in 1 .. children.size) {
          sums.add(children[ind - 1])
        }
      }
    }
//    list.addAll(string.slice(index until index + entriesCount))
    index += entriesCount
    return sums.sum()
  }
}


fun main() {
//  val s1 = Solution1()
//  s1.sumNodes()
  val s2 = Solution2()
  s2.getNodeValue()
}

