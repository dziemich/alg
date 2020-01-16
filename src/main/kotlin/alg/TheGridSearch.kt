package alg

fun gridSearch(G: Array<String>, P: Array<String>): String {

  val first = P.get(0)

  val pairsMatched = getPairsMatched(G, first)

  if (pairsMatched.isEmpty()) {
    return "NO"
  }

  for (match in pairsMatched) {
    if (detGrid(P, G, match)) {
      return "YES"
    }
  }
  return "NO"
}

private fun getPairsMatched(
  G: Array<String>,
  first: String
): List<Pair<Int, Int>> {
  val pairsOfMatches = mutableListOf<Pair<Int, Int>>()
  G.forEachIndexed { index, it ->
    val ind = it.indexOf(first)
    val indices = getAllIndices(first, it)
    indices.filter { it != -1 }
      .forEach { pairsOfMatches.add(index to it) }
  }
  return pairsOfMatches
}

private fun getAllIndices(string: String, line: String): MutableList<Int> {
  var index = line.indexOf(string)
  val list = mutableListOf<Int>()
  while (index >= 0) {
    list.add(index)
    index = line.indexOf(string, index + 1)
  }
  return list
}

private fun detGrid(
  P: Array<String>,
  G: Array<String>,
  p: Pair<Int, Int>
): Boolean {
  for (i in 1 until P.size) {
    val pattern = P[i]
    val gridLine = G[i + p.first]
    val indices = getAllIndices(pattern, gridLine)
    if (!indices.contains(p.second)) {
      return false
    }
  }
  return true
}

