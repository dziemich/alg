package alg

import alg.longestPalindrome
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LCLongestPalindronomicSubstringTest {
  @Test
  fun findsPalindronomicSubstringEasy(){
    Assertions.assertEquals("aka", longestPalindrome("cakaz"))
  }
  @Test
  fun findsPalindronomicSubstringEasier(){
    Assertions.assertEquals("akka", longestPalindrome("cakkaz"))
  }
  @Test
  fun findsPalindronomicSubstringHard(){
    Assertions.assertEquals("bab", longestPalindrome("babol"))
  }
  @Test
  fun findsPalindronomicSubstringHarder(){
    Assertions.assertEquals("baaab", longestPalindrome("baaabol"))
  }
  @Test
  fun findsPalindronomicSubstringHardest(){
    Assertions.assertEquals("ttt", longestPalindrome("rattt"))
  }
  @Test
  fun findsPalindronomicSubstringHardest3(){
    Assertions.assertEquals("a", longestPalindrome("abcda"))
  }
  @Test
  fun findsPalindronomicSubstringHardest4(){
    Assertions.assertEquals("aaabaaa", longestPalindrome("aaabaaaa"))
  }
  @Test
  fun findsPalindronomicSubstringHardest5(){
    Assertions.assertEquals("aaaa", longestPalindrome("aaaa"))
  }
}
