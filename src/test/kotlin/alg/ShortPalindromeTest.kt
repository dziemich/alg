package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ShortPalindromeTest {
  @Test
  fun test0(){
    Assertions.assertEquals(15, shortPalindrome("kkkkkkz"))
    Assertions.assertEquals(4, shortPalindrome("abbaab"))
    Assertions.assertEquals(2, shortPalindrome("akakak"))
  }

  @Test
  fun test3(){
    Assertions.assertEquals(59222, x("baabababaaaababbbbbbabbbbabbbaaabaaabbbbaabbbbbbab"))
  }

  @Test
  fun between(): Unit {
    Assertions.assertEquals(5, getBetweenItself(3,2))
    Assertions.assertEquals(15, getBetweenItself(3,3))
  }

}
