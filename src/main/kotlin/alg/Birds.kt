package alg

fun migratoryBirds(arr: Array<Int>): Int {
  val sightings = IntArray(5)
  arr.forEach {
    sightings[it]++
  }
  return sightings.indexOf(sightings.max()!!);
}

fun pickingNumbers(a: Array<Int>): Int {
  val groupBy: Map<Int, List<Int>> = a.groupBy { it }
  var highest = 0

  groupBy.forEach{
    val lessBy1 = groupBy.getOrDefault(it.key - 1 , emptyList()).size;
    val moreBy1 = groupBy.getOrDefault(it.key + 1, emptyList()).size;

    val max = it.value.size + Math.max(lessBy1, moreBy1)
    highest = if (max > highest) {
      max
    } else {
      highest
    }
  }
  return highest
}

fun encryption(s: String): String {
  val noSpacebar = s.replace(" ", "")
  val dblLen = noSpacebar.length.toDouble()
  val cols = Math.ceil(Math.sqrt(dblLen));

  val floored = Math.floor(Math.sqrt(dblLen))

  val rows = if(floored * cols > dblLen ){
    floored
  } else {
    cols
  }

  val words = mutableListOf<String>()
  for (i in 0 until cols.toInt()){
    var word = ""
    var j = i
    while (j < noSpacebar.length){
      val newW = noSpacebar[j]
      word += newW
      j += cols.toInt()
    }
    words.add(word)
  }
  val joined = words.joinToString(separator = " ");
  return joined
}

fun main(){
  println(encryption("feedthedog"));
}
