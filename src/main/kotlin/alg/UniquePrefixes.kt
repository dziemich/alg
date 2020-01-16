package alg

fun findUniquePrefixes(arr: Array<String>): Array<String> {
  val retArr = arrayOfNulls<String>(arr.size)

  for (i in 0 until arr.size) {
    val prefix = findPrefix(arr[i], arr)
    retArr[i] = prefix
  }
  return retArr as Array<String>
}

fun findPrefix(word: String, arr: Array<String>): String {
  for (i in 0 until word.length) {
    val substring = word.substring(0..i)
    val filtered = arr
      .filter { it.startsWith(substring) }
    if (filtered.size == 1) {
      return substring
    }
  }
  throw IllegalStateException()
}
