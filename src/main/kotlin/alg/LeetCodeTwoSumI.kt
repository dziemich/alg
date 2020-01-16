package alg

fun twoSum(nums: IntArray, target: Int): IntArray {
  val map: HashMap<Int, Int> = HashMap()
  for (i in 0 until nums.size) {
    val get: Int? = map.get(nums[i])
    if (get != null) {
      return intArrayOf(get, i)
    } else {
      map.put(target - nums[i], i)
    }
  }
  return intArrayOf()
}

fun twoSum2(numbers: IntArray, target: Int): IntArray {
  var i = 0;
  var j = numbers.size - 1
  while (i < j) {
    if (numbers[i] + numbers[j] > target) j--
    if (numbers[i] + numbers[j] < target) i++
    if (numbers[i] + numbers[j] == target) return intArrayOf(i + 1, j + 1)
  }
  return intArrayOf()
}


fun pairs(k: Int, arr: Array<Int>): Int {
  val map: HashMap<Int, Int> = HashMap()
  var cnt = 0;
  for (i in 0 until arr.size) {
    val number = arr[i]
    if (map[number] != null) {
      cnt += map[number]!!
      map.merge(number - k, 1) { _, v -> v + 1 }
      map.merge(number + k, 1) { _, v -> v + 1 }
    } else {
      map.merge(number - k, 1) { _, v -> v + 1 }
      map.merge(number + k, 1) { _, v -> v + 1 }
    }
  }
  return cnt
}

fun balancedSums(arr: Array<Int>): String {
  var i = 0;
  var j = arr.size - 1;
  var leftSum = 0;
  var rightSum = 0;

  while (i < j) {
    val lComp = leftSum + arr[i]
    val rComp = rightSum + arr[j]
    if (lComp == rComp) {
      if (j - i == 2) {
        return "YES"
      }
      else if (arr[i] == arr[j]) {
        i++
        j--
      }
      else if (arr[i] > arr[j]){
        rightSum += arr[j]
        j--
      }
      else if (arr[i] < arr[j]){
        leftSum += arr[i]
        i++
      }
      else if (j -i == 1) {
        return "NO"
      }
    } else if (lComp < rComp) {
      leftSum += arr[i]
      i++
    } else if (lComp > rComp) {
      rightSum += arr[j]
      j--
    }
  }
  if(leftSum == rightSum) return "YES"
  return "NO"
}
