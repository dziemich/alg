package alg

import java.lang.IllegalStateException

val words = mapOf<Int, String>(
  1 to "one",
  2 to "two",
  3 to "three",
  4 to "four",
  5 to "five",
  6 to "six",
  7 to "seven",
  8 to "eight",
  9 to "nine",
  10 to "ten",
  11 to "eleven",
  12 to "twelve",
  13 to "thirteen",
  14 to "fourteen",
  15 to "fifteen",
  16 to "sixteen",
  17 to "seventeeen",
  18 to "eighteen",
  19 to "nineteen",
  20 to "twenty",
  30 to "thirty"
)

fun timeInWords(h: Int, m: Int): String {

  if( h > 12 || h < 0){
    throw IllegalStateException("hour is $h")
  }

  if( h > 60 || h < 0){
    throw IllegalStateException("minute is $m")
  }



  if (m == 0) {
    return "${h.toEnglishString()} o'clock"
  }

  val builder = mutableListOf<String>()

  val minString = if (m == 1 || m == 59) {
    "minute"
  } else {
    "minutes"
  }

  val hour = if (m <= 30) {
    h.toEnglishString()
  } else {
    ((h + 1) % 12).toEnglishString()
  }

  if (m < 30) {
    if (m % 15 == 0) {
      builder.add("quarter")
    } else {
      builder.add("${m.toEnglishString()} $minString")
    }
    builder.add("past")
  } else if (m == 30) {
    builder.add("half past")
  } else {
    if (m % 15 == 0) {
      builder.add("quarter")
    } else {
      builder.add("${(60 - m).toEnglishString()} $minString")
    }
    builder.add("to")
  }
  builder.add(hour)

  return builder.joinToString(separator = " ")
}

fun Int.toEnglishString(): String {
  if (this == 30) {
    return words[this]!!;
  }
  if (this > 20) {
    return "${words[20]} ${words[this - 20]}"
  }
  return words[this]!!;
}
