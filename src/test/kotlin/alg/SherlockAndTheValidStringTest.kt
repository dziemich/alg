package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SherlockAndTheValidStringTest {
  @Test
  fun test(): Unit {
    Assertions.assertEquals("YES", isValid("aabbcc"))
  }

  @Test
  fun test5(): Unit {
    Assertions.assertEquals("YES", isValid("aabbccc"))
  }

  @Test
  fun test2(): Unit {
    Assertions.assertEquals("YES", isValid("aaabbcc"))
  }

  @Test
  fun test3(): Unit {
    Assertions.assertEquals("YES", isValid("aaaabbcc"))
  }

  @Test
  fun test4(): Unit {
    Assertions.assertEquals("YES", isValid("aaabbbcc"))
  }

  @Test
  fun test6(): Unit {
    Assertions.assertEquals("NO", isValid("aaaabbbccccc"))
  }

  @Test
  fun testMed(): Unit {
    Assertions.assertEquals(1, findMed(1,1,2))
  }
  @Test
  fun testMed2(): Unit {
    Assertions.assertEquals(1, findMed(1,2,1))
  }
  @Test
  fun testMed3(): Unit {
    Assertions.assertEquals(1, findMed(2,1,1))
  }
}
