package alg

fun String.differs(other: String): Int {
  var counter = 0
  for (i in 0 until this.length) {
    if (this[i] != other[i]) counter++
  }
  return counter
}

fun String.matches(other: String): Boolean {
  return this.differs(other) == 1
}

fun prep(
  start: String,
  end: String,
  dictionary: List<String>
): MutableList<String> {
  val beginning = findPath(start, end, dictionary, mutableListOf(start))
  return when(beginning.size){
    1 -> mutableListOf();
    else -> beginning
  }
}

fun findPath(
  start: String,
  end: String,
  dictionary: List<String>,
  l: MutableList<String>
): MutableList<String> {
  for (s: String in dictionary) {
    if (start.matches(s) and !l.contains(s)) {
      val deepCopy = deepCopy(l)
      deepCopy.add(s)
      val i = findPath(s, end, dictionary, deepCopy)
      if(i.last() == end) return i
    }
  }
  return l
}

fun <T>deepCopy(list: MutableList<T>): MutableList<T>{
  return list.toMutableList();
}
