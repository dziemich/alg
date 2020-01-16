package alg/*
Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.

For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:

There is 1 smaller element to the right of 3
There is 1 smaller element to the right of 4
There are 2 smaller elements to the right of 9
There is 1 smaller element to the right of 6
There are no smaller elements to the right of 1
 */

fun findSmallerToTheRight(arr: IntArray): IntArray {
  if (arr.isEmpty()){
    return IntArray(0)
  }

  if (arr.size == 1) {
    return intArrayOf(0)
  }

  val retArr: IntArray = IntArray(arr.size)
  val list: Array<Pair<Int, Int>?> = arrayOfNulls(arr.size)

  var prev = arr[arr.size - 1] to 0
  list.set(arr.size - 1, prev)

  for (i in arr.size - 2 downTo 0) {
    val currentElement = arr[i]
    if (currentElement > prev.first) {
      val pair = currentElement to prev.second + 1
      list[i] = (pair)
      retArr.set(i, prev.second + 1)
      prev = pair
    } else {
      for (j in i + 1 until arr.size) {
        if (currentElement > list[j]!!.first) {
          list.set(i, currentElement to list[j]!!.second + 1)
          retArr.set(i, list[j]!!.second + 1)
          break
        }
        if (j == arr.size - 1) {
          val updatedField = currentElement to 0
          list.set(i, updatedField);
          retArr.set(i, 0)
        }
      }
    }
  }
  return retArr
}
