package aoc2018

import java.util.*

//fun elfGame(players: Int, marbles: Int) {
//
//  val playersScores = IntArray(players)
//
//  var roundCounter = 2
//  var currentMarbleIndex = 1
//
//  val circle = mutableListOf<Int>()
//
//  circle.add(0)
//  circle.add(1)
//
//  while (roundCounter < marbles) {
//    println(roundCounter)
//    if (roundCounter % 23 == 0) {
//      if (currentMarbleIndex - 7 < 0) {
//        val index = currentMarbleIndex - 7 + circle.size
//        currentMarbleIndex = index
//        val score = circle.removeAt(index) + roundCounter
//        playersScores[roundCounter % players] += score
//      } else {
//        val index = currentMarbleIndex - 7
//        currentMarbleIndex = index
//        val score = circle.removeAt(index) + roundCounter
//        playersScores[roundCounter % players] += score
//      }
//    } else {
//      val index = (currentMarbleIndex + 2) % (circle.size)
//      circle.add(index, roundCounter)
//      currentMarbleIndex = index
//    }
//    roundCounter++
//  }
//  println(playersScores.max())
//}

fun main() {
  val path = "day09/input.txt"
  val (players, lastMarble) = 423 to 7_194_400

  val points = UIntArray(players) { 0U }
  val circle = LinkedList<Int>(listOf(0))

  (1..lastMarble).forEach { marble ->
    if (marble.rem(23) == 0) {
      (0 until 7).forEach { circle.addFirst(circle.removeLast()) }
      points[(marble - 1).rem(players)] += (marble + circle.removeFirst()).toUInt()
    } else {
      (0 until 2).forEach { circle.addLast(circle.removeFirst()) }
      circle.addFirst(marble)
      println("x")
    }
  }

  val res = points.max()
  System.out.println("Answer: $res")
}

//fun main() {
//  elfGame(423, 7_194_400);
//}
