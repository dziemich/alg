package alg

/*
https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */


fun biggerIsGreater2(w: String): String {

  val (pair, swapHappened) = balance(w, 0) { a, b -> a < b }

  if (!swapHappened) {
    return "no answer"
  }

  var word = swap(w, pair.first, pair.second)

  return word.substring(
    0,
    pair.second + 1
  ) + word.substring(pair.second + 1).split("").sorted().joinToString(separator = "")

}

fun balance(
  w: String,
  constraint: Int,
  comp: (Int, Int) -> Boolean
): Pair<Pair<Int, Int>, Boolean> {
  for (i in w.length - 1 downTo constraint) {
    for (j in i - 1 downTo constraint) {
      if (comp.invoke(w[j].ascii(), w[i].ascii())) {
        return (i to j) to true
      }
    }
  }
  return (-1 to -1) to false;
}

fun Char.ascii(): Int {
  return this.toInt()
}

fun swap(input: String, pos1: Int, pos2: Int): String {
  val chars = input.toMutableList()
  val temp = chars[pos1]
  chars[pos1] = chars[pos2]
  chars[pos2] = temp
  return chars.joinToString(separator = "")
}


fun biggerIsGreater(w: String): String {
  // find pivot
  val pivot = findPivot(w)
  if (pivot == -1) return "no answer"
  // find first larger than pivot
  // https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
  val swappee = findSwappee(w, w[pivot])
  if (swappee == -1) {
    throw IllegalStateException()
  }

  val swapped = swap(w, pivot, swappee)

  return swapped.substring(0, pivot + 1) + swapped.substring(pivot + 1).reversed()
}

fun findPivot(word: String): Int {
  for (i in word.length - 1 downTo 1) {
    if (word[i].ascii() > word[i - 1].ascii()) {
      return i - 1;
    }
  }
  return -1
}

fun findSwappee(word: String, pivotValue: Char): Int {
  for (i in word.length - 1 downTo 0) {
    if (word[i].ascii() > pivotValue.ascii()) {
      return i
    }
  }
  return -1
}
