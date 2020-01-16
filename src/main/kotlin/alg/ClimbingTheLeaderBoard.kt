package alg

/*

https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */

fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {

  val p = arrayOfNulls<Int>(alice.size)

  val sortedBy = alice.toMutableList()
    .mapIndexed { index, ints -> index to ints }
    .sortedBy { it.second }
    .reversed()

  var index = 0;

  val scoresDistinct = scores.distinct();

  sortedBy.forEach { pair ->
    for(i in index .. scoresDistinct.size ){
      if (i == scoresDistinct.size){
        p[pair.first] = index + 1
        break
      }
      if (scoresDistinct[i] <= pair.second){
        p[pair.first] = index + 1
        break
      }
      else {
        index++
      }

    }
  }

  return p as Array<Int>;
}
