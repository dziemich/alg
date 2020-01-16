//package aoc2018
//
//
//class Solution {
//
//  val res = mutableListOf<Int>()
//  val input = FileHelper.readLines("day8.txt")
//    .flatMap { it.split(" ") }
//    .map { Integer.parseInt(it) }
//
//
//  fun getSum(start: Int) {
//    val childrenCount = input[start]
//    val metadataCount = input[start + 1]
//
//    for (i in 1..childrenCount) {
//      index += 2
//      list.addAll(build(string, list))
//    }
//  }
//
//  fun main() {
//    getSum(0)
//  }
//}
