package alg

fun main(args: Array<String>) {

  val _1 : String = "ala"
  val _2 : String = "alala"

  val message = verifyCaseSensitive(_1, _2)
  println(message)
}

fun constructOccurrenceMap(first: String): MutableMap<Char, Long> {
  val occurences : MutableMap<Char, Long> = HashMap()
  first.forEach {
    occurences.putIfAbsent(it, 0)
    occurences.computeIfPresent(it){ _, v -> v.plus(1)}
  }
  return occurences
}

fun verifyCaseSensitive(first: String, second: String): Boolean {
  if (first.length != second.length) return false

  val occurrenceMap = constructOccurrenceMap(first)
  second.forEach {
    if (!occurrenceMap.containsKey(it)){
      return false
    }
    occurrenceMap.computeIfPresent(it){ _, v -> v.minus(1)}
    if (occurrenceMap.getValue(it) == 0L){
      occurrenceMap.remove(it)
    }
  }
  return occurrenceMap.isEmpty()
}

fun verifyCaseInsensitive(first: String, second: String) : Boolean{
  return verifyCaseSensitive(first.toLowerCase(), second.toLowerCase())
}

fun sanitize(s : String) : String {
  return s
    .replace(" ", "")
    .replace("!", "")
    .replace(".", "")
    .replace(",", "")
    .replace("?", "")
    .replace("-", "")
    .toLowerCase()
}

fun verifySentences(first: String, second: String) : Boolean{
  return verifyCaseSensitive(sanitize(first), sanitize(second))
}

fun verifySentencesWordByWord(first: String, second: String): Boolean{
  val splitFirst = first.split(" ")
  val splitSecond = second.split(" ")
  if (splitFirst.size != splitSecond.size) return false;
  for(i in 0 until splitFirst.size){
    if (!verifyCaseInsensitive(splitFirst[i], splitSecond[i])) return false;
  }
  return true;
}
