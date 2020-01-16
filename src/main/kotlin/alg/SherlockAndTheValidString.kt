package alg

/*

https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */

fun isValid(s: String): String {

  val list = s
    .groupBy { it }
    .map { it.value.size }
    .toMutableList()


  if (list.size <= 2){
    return "YES"
  }

  val el0 = list[0]
  val el1 = list[1]
  val el2 = list[2]

  val med = findMed(el0, el1, el2)

  if(med == -1){
    return "NO"
  }

  val count = list.filter { it != med }
    .count()

//  val valid = list.all { it == med || it == med + 1 }

  return if (count <=1) "YES" else "NO"
}

fun findMed(e1: Int, e2: Int, e3: Int): Int{

  if (e1 == e2 && e2 == e3) return e1
  if (e1 == e2 && e2 != e3) return e1
  if (e1 == e3 && e2 != e3) return e1
  if (e2 == e3 && e1 != e3) return e2
  return -1
}
