package alg

fun longestPalindrome(s: String): String {
  if (s.isBlank()) return ""
  if(s.allAreTheSame()) return s
  var largest = s.substring(0, 1)
  for (i in 0 until s.length) {
    val candidate = determinePalindrome(i, s)
    if (candidate.length >= largest.length) {
      largest = candidate
    }
  }
  return largest
}

fun String.allAreTheSame(): Boolean{
  for (i in 0 until this.length){
    if (this[i] != this[0])
      return false
  }
  return true
}

fun determinePalindrome(index: Int, s: String): String {
  var left = index - 1;
  var right = index + 1;
  var ret = s.substring(index, index + 1)

  if (left >= 0 && s[left] == s[index] && right <= s.length - 1 && s[right] == s[index]) {
    ret = s.substring(left..right)
    left--
    right++
  }

  if (left >= 0 && s[left] == s[index]) {
    ret = s.substring(left..index)
    left--
  }

  if (right <= s.length - 1 && s[right] == s[index]) {
    ret = s.substring(index..right)
    right++
  }

  while (left >= 0 && right <= s.length - 1) {
    if (s[left] == s[right]) {
      ret = s.substring(left..right)
      left--
      right++
    } else {
      break
    }
  }
  return ret
}
