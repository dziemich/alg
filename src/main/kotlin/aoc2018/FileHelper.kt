package aoc2018

import java.io.File

object FileHelper {
  fun readLines(filename: String): List<String> {
    return File(ClassLoader.getSystemResource(filename).file)
      .readLines()
      .map(String::trim)
      .filter(String::isNotEmpty)
  }
}
